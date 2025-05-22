package com.bookapp.service;

import com.bookapp.model.ApiUser;
import com.bookapp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApiUserServiceImpl implements UserDetailsManager {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void createUser(UserDetails user) {
        String username =user.getUsername();
        String password = user.getPassword();
        Set<String> roles = user.getAuthorities()
                .stream()
                .map(Object::toString).collect(Collectors.toSet());
        ApiUser apiUser = new ApiUser(null,username,password,roles);
        userRepository.save(apiUser);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      ApiUser user =  userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
      String uname = user.getUsername();
      String password = user.getPassword();
        System.out.println(user);
       UserDetails userDetails   = new User(uname,password,user.getAuthorities());
        System.out.println(userDetails);
      return userDetails;



    }
}

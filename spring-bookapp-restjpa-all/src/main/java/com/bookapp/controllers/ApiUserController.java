package com.bookapp.controllers;

import com.bookapp.model.ApiUser;
import com.bookapp.model.ApiUserDto;
import com.bookapp.service.ApiUserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-api/v1")
public class ApiUserController {
     @Autowired
     private ApiUserServiceImpl userService;
     @Autowired
     private ModelMapper mapper;

      @Autowired
      private PasswordEncoder encoder;

     @PostMapping("/register")
      ResponseEntity<Void> registerUser(@RequestBody ApiUserDto apiUserDto){
          ApiUser apiUser = mapper.map(apiUserDto, ApiUser.class);
          String password = encoder.encode(apiUser.getPassword());
          apiUser.setPassword(password);
          userService.createUser(apiUser);
          return ResponseEntity.status(201).build();
     }


}

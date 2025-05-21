package com.bookapp.config;

import com.bookapp.service.ApiUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

     @Autowired
     private ApiUserServiceImpl apiUserService;
     //bean for authentication,
    @Bean
    public UserDetailsService userDetailsService() {
        return  new ApiUserServiceImpl();
    }

    //bean for authenticationprovider
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    //bean for PasswordEncoder
    @Bean
    PasswordEncoder encoder() {
        return  new BCryptPasswordEncoder();
    }
   //authorization
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth->{
            auth.requestMatchers("/user-api/v1/register").permitAll();
        })
                .formLogin(Customizer.withDefaults())
                .build();



    }


}












package com.bookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //bean for authentication,
    //bean for authenticationprovider
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












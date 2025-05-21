package com.bookapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //create a bean definition
    @Bean
    ModelMapper mapper() {
        return new ModelMapper();
    }

}

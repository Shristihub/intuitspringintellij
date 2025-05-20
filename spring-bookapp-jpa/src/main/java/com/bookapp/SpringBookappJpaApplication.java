package com.bookapp;

import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBookappJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBookappJpaApplication.class, args);
    }

    @Autowired
    private IBookService bookService;
    @Override
    public void run(String... args) throws Exception {

    }
}

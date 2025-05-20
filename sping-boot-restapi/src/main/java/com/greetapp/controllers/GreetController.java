package com.greetapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GreetController {

    //    http://localhost:8081/greet/username/Priya
    @GetMapping("/greet/username/{username}")
    public String greet(@PathVariable String username ){
        return "Have a great day "+username;
    }
    @GetMapping("/show-books")
    public List<String> showBooks(){
        return List.of("Java","Angular");
    }
  // http://localhost:8081/details?username=Priya&city=Bangalore
  @GetMapping("/details")
  public String showDetails(@RequestParam String username, @RequestParam  String city){
        return "Welcome "+username +" to "+city;

  }

}

package com.greetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class GreetController {

    @GetMapping("/greet")
    public String greetMessage(ModelMap model){
        // from here call the service layer
        //service returns the data
        String gmessage = "Have a great day";
        //bundle the data
        model.addAttribute("message",gmessage);
        //return the jsp page name
        return "success";
    }
    @GetMapping("/sayHello")
    public String sayHello(ModelMap modelMap){
        List<String> books = List.of("Java","Angular","React");
        modelMap.addAttribute("bookList",books);
        return "success";
    }

}

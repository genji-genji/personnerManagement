package com.example.personnelmanagement.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomController {

    @RequestMapping("/index")
    public String welcom(){
        return "index";
    }
}

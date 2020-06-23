package com.example.personnelmanagement.controller;

import com.example.personnelmanagement.bean.UserBean;
import com.example.personnelmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String sayHello(){
        return "login";
    }
    @RequestMapping(value = "/getUserBean" , method = RequestMethod.POST)
    public UserBean getUserBean(String user_id,String password){
        return userService.check(user_id,password);
    }
    @RequestMapping(value = "/askLogin",method = RequestMethod.POST)
    public String login(String user_id,String password){
        UserBean userBean=userService.check(user_id,password);
        if (userBean!=null){
            return "main";
        }
        else
            return "loginErro";
    }
}

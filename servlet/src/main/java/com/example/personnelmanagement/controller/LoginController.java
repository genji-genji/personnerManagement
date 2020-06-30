package com.example.personnelmanagement.controller;

import com.example.personnelmanagement.bean.UserBean;
import com.example.personnelmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login", method =RequestMethod.GET)
    public UserBean sayHello(@RequestParam String username, @RequestParam String password, HttpSession session ){

       UserBean userBean= userService.check(username,password);
       if (userBean!=null){
           session.setAttribute("users",userBean);
       }
        return userBean;
    }
//    @RequestMapping(value = "/getUserBean" , method = RequestMethod.POST)
//    public UserBean getUserBean(String user_id,String password){
//        return userService.check(user_id,password);
//    }
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

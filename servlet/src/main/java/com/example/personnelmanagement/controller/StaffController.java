package com.example.personnelmanagement.controller;

import com.example.personnelmanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;
    @RequestMapping("/serchStaff")
    public String getStaff(){
        return "staffManage";
    }

}

package com.example.personnelmanagement.controller;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;
//    @RequestMapping(value = "/serchStaff",method = RequestMethod.GET)
//    public StaffBean getStaff(@RequestParam (value = "staffId")){
//
//    }



}

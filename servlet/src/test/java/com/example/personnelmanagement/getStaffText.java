package com.example.personnelmanagement;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.service.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class getStaffText {
    @Autowired
    StaffService staffService;

    @Test
    public void test(){
        StaffBean staffBean =staffService.getStaffMessage(10000);
        System.out.println(staffBean);
    }

}

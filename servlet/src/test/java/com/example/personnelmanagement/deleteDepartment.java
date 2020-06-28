package com.example.personnelmanagement;

import com.example.personnelmanagement.bean.DepartmentBean;
import com.example.personnelmanagement.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class deleteDepartment {
    @Autowired
    DepartmentService departmentService;

    @Test
    public void deleteDepartment() {
        DepartmentBean departmentBean = departmentService.deleteDepartment(5);

        System.out.println("success");


    }
}
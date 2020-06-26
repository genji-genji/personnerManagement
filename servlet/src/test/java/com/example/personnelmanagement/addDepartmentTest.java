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

public class addDepartmentTest {
    @Autowired
    DepartmentService departmentService;

    @Test
    public void addDepartmentTest(){
        DepartmentBean departmentBean = new DepartmentBean(4,"孵化池","department",156234853,20170604);
        System.out.println(departmentService.addDepartment(departmentBean));

    }
}
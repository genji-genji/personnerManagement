package com.example.personnelmanagement;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.service.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class quitStaffText {
    @Autowired
    StaffService staffService;
    @Test
    public void test(){

        StaffBean staffBean =new StaffBean();
        staffBean.setSid(10001);
       System.out.println(staffService.quitStaff(staffBean));
    }
}

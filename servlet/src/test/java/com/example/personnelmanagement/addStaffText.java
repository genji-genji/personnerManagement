package com.example.personnelmanagement;


import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.service.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class addStaffText {
    @Autowired
    StaffService staffService;

    @Test
    public void addStaffTest(){
        StaffBean staffBean=new StaffBean(0,"女","颜玉书","1995-4-27","478658199504273075",1,2,2,1,2);
        staffBean.setSid(staffService.getMaxSid()+1);
        System.out.println(staffService.addStaff(staffBean));
    }
}

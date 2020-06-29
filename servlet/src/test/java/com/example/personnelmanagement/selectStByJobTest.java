package com.example.personnelmanagement;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class selectStByJobTest {
    @Autowired
    JobService jobService;

    @Test
    public void test(){
        List<StaffBean> list=jobService.selectStaffByJob(1);
        System.out.println(list.size());
        for (int i=0 ;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

}

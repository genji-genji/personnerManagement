package com.example.personnelmanagement;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class updateJobTest {
    @Autowired
    JobService jobService;

    @Test
    public void Test(){
        JobBean jobBean =new JobBean(7,"水表员",0,20,3);
        System.out.println(jobService.updateJob(jobBean));
    }
}

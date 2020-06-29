package com.example.personnelmanagement;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class addJobTest {
    @Autowired
    JobService jobService;

    @Test
    public void test(){
        JobBean jobBean =new JobBean(0,"和谐员",0,20,3);
        System.out.println(jobService.addJob(jobBean));
    }

}

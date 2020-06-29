package com.example.personnelmanagement;

import com.example.personnelmanagement.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class deleteJobTest {
    @Autowired
    JobService jobService;
    @Test
    public void Test(){
        try {
            int jage_1 = jobService.deleteJob(1);
            System.out.println(jage_1);
        }catch (Exception e){
            System.out.println("错误1");
        }
        try {
            int jage_2=jobService.deleteJob(7);
            System.out.println(jage_2);
        }catch (Exception e){
            System.out.println("错误7");
        }


    }
}

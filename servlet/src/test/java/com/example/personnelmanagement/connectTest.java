package com.example.personnelmanagement;

import com.example.personnelmanagement.bean.UserBean;
import com.example.personnelmanagement.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class connectTest {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        UserBean userBean = userService.check("root", "123456");
        System.out.println("该用户ID为：");
        System.out.println(userBean.getUser_id());
    }
}



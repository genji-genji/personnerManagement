package com.example.personnelmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.personnelmanagement.mapper")
@SpringBootApplication
public class PersonnelmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelmanagementApplication.class, args);
    }

}

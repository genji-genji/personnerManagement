package com.example.personnelmanagement.serviceImpl;

import com.example.personnelmanagement.bean.UserBean;
import com.example.personnelmanagement.mapper.UserMapper;
import com.example.personnelmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserMapper userMapper;

    @Override
    public UserBean check(String userId, String password){
        return userMapper.getInfo(userId,password);
    }

}

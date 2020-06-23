package com.example.personnelmanagement.mapper;

import com.example.personnelmanagement.bean.UserBean;

public interface UserMapper {
    UserBean getInfo(String userId,String password);
}

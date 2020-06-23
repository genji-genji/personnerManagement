package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.UserBean;

public interface UserService {
    UserBean check(String useId, String password);
}

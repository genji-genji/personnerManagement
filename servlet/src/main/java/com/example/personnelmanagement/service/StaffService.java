package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.mapper.StaffMapper;
import org.springframework.stereotype.Service;


public interface StaffService {
    StaffBean getStaffMessage(int staffId);
}

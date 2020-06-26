package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.bean.UserBean;
import com.example.personnelmanagement.mapper.StaffMapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StaffService {
    StaffBean getStaffMessage(int staffId);
    List<StaffBean> getStaffList();
    int changeStaffMsg(int staffId);
    int addStaff(StaffBean staffBean);
    int addStaffHasT(StaffBean staffBean);
    int getMaxSid();
    int getStaffNum();
    int quitStaff(StaffBean staffBean);
}

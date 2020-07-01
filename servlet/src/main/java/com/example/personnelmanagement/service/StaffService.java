package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.bean.UserBean;
import com.example.personnelmanagement.mapper.StaffMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface StaffService {
    StaffBean getStaffMessage(int staffId);
    List<Map<String,Object>> getNewStaffList();
    List<Map<String,Object>> getFormList();
    List<Map<String,Object>> getOriginList();
    int changeStaffMsg(int staffId);
    int addStaff(StaffBean staffBean);
    int addStaffHasT(StaffBean staffBean);
    int getMaxSid();
    int getStaffNum();
    int quitStaff(StaffBean staffBean);
}

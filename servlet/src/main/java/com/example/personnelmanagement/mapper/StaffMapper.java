package com.example.personnelmanagement.mapper;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.bean.UserBean;

import java.util.List;
import java.util.Map;

public interface StaffMapper {
//    获得员工信息
    StaffBean getStaff(int staffId);
    List<Map<String,Object>> getNewStaffList();
    List<Map<String,Object>> getFormList();
    List<Map<String,Object>> getOriginList();
//   添加员工
    int addStaff(StaffBean staffBean);
    int addStaffHasT(StaffBean staffBean);

    int quitStaff(StaffBean staffBean);
    List<Map<String,Object>> getQuitStaffList();
    List<Map<String,Object>> getNowStaffList();


    int getMaxSid();

    int getStaffNum();

    int changeStaffMsg(int staffId);
//    int updateTest();
}

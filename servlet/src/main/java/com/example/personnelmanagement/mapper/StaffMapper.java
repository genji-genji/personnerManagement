package com.example.personnelmanagement.mapper;

import com.example.personnelmanagement.bean.StaffBean;

public interface StaffMapper {
//    获得员工信息
    StaffBean getStaff(int staffId);
//   添加员工
    int addStaff(StaffBean staffBean);

    int quitStaff(int staffId);

    int getMaxSid();

    int getStaffNum();
}

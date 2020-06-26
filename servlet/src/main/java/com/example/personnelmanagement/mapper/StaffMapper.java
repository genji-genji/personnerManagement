package com.example.personnelmanagement.mapper;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.bean.UserBean;

public interface StaffMapper {
//    获得员工信息
    StaffBean getStaff(int staffId);
//   添加员工
    int addStaff(StaffBean staffBean);

    int quitStaff(StaffBean staffBean);

    int getMaxSid();

    int getStaffNum();
}

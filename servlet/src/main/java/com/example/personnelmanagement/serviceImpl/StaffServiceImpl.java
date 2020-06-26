package com.example.personnelmanagement.serviceImpl;

import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.bean.UserBean;
import com.example.personnelmanagement.mapper.StaffMapper;
import com.example.personnelmanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public StaffBean getStaffMessage(int staffId){
        return staffMapper.getStaff(staffId);
    }

    @Override
    public int addStaff(StaffBean staffBean){
        int num1=staffMapper.getStaffNum();
        int num2;
        int jage;

        staffMapper.addStaff(staffBean);
        jage=staffBean.getJage();
        return jage;
    }

//    jage表示操作是否成功
    @Override
    public int quitStaff(StaffBean staffBean){
        staffMapper.quitStaff(staffBean);
        return staffBean.getJage();
    }
    @Override
    public int getMaxSid(){return staffMapper.getMaxSid();}
    @Override
    public int getStaffNum(){return  staffMapper.getStaffNum();}
}

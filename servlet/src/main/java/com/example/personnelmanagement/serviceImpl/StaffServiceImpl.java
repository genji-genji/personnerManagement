package com.example.personnelmanagement.serviceImpl;

import com.example.personnelmanagement.bean.StaffBean;
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
        int jage=0;

        staffMapper.addStaff(staffBean);
        num2=staffMapper.getStaffNum();

        if (num2>num1){
            jage=1;
        }
//        num2>num1即数据增加 添加成功
        return jage;
    }

    @Override
    public int quitStaff(int staffId){
        return staffMapper.quitStaff(staffId);
    }
    @Override
    public int getMaxSid(){return staffMapper.getMaxSid();}
    @Override
    public int getStaffNum(){return  staffMapper.getStaffNum();}
}

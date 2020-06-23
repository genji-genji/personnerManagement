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
}

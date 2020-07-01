package com.example.personnelmanagement.serviceImpl;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.bean.UserBean;
import com.example.personnelmanagement.mapper.JobMapper;
import com.example.personnelmanagement.mapper.StaffMapper;
import com.example.personnelmanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private JobMapper jobMapper;

    @Override
    public StaffBean getStaffMessage(int staffId){
        return staffMapper.getStaff(staffId);
    }

    @Override
    public List<Map<String,Object>> getNewStaffList() {
        return staffMapper.getNewStaffList();
    }

    @Override
    public int changeStaffMsg(int staffId) {
        return staffMapper.changeStaffMsg(staffId);
    }

    @Override
    public int addStaff(StaffBean staffBean){
        int jage;
//        判断是否超过最大人数
        JobBean beanToJage =jobMapper.getCM(staffBean.getJob_id());
        if (beanToJage.getCurrent_number()+1<=beanToJage.getMax_number()){
        staffBean.setSid(staffMapper.getMaxSid()+1);
        staffMapper.addStaff(staffBean);
        jage=staffBean.getJage();
        }else {
            jage=0;
    }
        return jage;
    }

    @Override
    public int addStaffHasT(StaffBean staffBean) {
        int jage;
        JobBean beanToJage =jobMapper.getCM(staffBean.getJob_id());
        if (beanToJage.getCurrent_number()+1<=beanToJage.getMax_number()) {

            staffBean.setSid(staffMapper.getMaxSid() + 1);
            staffMapper.addStaffHasT(staffBean);
             jage = staffBean.getJage();
        }else {
            jage=0;
        }
        return jage;
    }

    //    jage表示操作是否成功
    @Override
    public int quitStaff(StaffBean staffBean){
        staffMapper.quitStaff(staffBean);
        return staffBean.getJage();
    }
    @Override
    public List<Map<String,Object>> getQuitStaffList() {
        return staffMapper.getQuitStaffList();
    }
    @Override
    public int getMaxSid(){return staffMapper.getMaxSid();}
    @Override
    public int getStaffNum(){return  staffMapper.getStaffNum();}

    @Override
    public List<Map<String, Object>> getFormList() {
        return staffMapper.getFormList();
    }

    @Override
    public List<Map<String, Object>> getOriginList() {
        return staffMapper.getOriginList();
    }

    @Override
    public List<Map<String, Object>> getNowStaffList() {
        return staffMapper.getNowStaffList();
    }
}

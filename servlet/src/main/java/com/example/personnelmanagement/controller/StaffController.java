package com.example.personnelmanagement.controller;

import com.example.personnelmanagement.bean.MessageBean;
import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.mapper.StaffMapper;
import com.example.personnelmanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;
    @RequestMapping(value = "/serchStaff",method = RequestMethod.GET)
    public StaffBean getStaff(@RequestParam (value = "staffId")int staffId){
        return staffService.getStaffMessage(staffId);
        }
    @RequestMapping(value = "/addStaff",method = RequestMethod.POST)
    public MessageBean addStaff(int sid,String sex,String name,String birthday,String id_no,
                                int origin_id,int form_id,int department_id,int job_id,int statu_id){
        StaffBean staffBean=new StaffBean(sid,sex,name,birthday,id_no,origin_id,form_id,department_id,job_id,statu_id);

        int result;
        //无试用期入职
        if (statu_id == 2) {


            result = staffService.addStaff(staffBean);
        }
        //试用期入职
        else {
            result = staffService.addStaffHasT(staffBean);
        }
//
        if (result==1){
            return new MessageBean("succes","添加成功");
        }
        else {
            return new MessageBean("erro","添加失败");
        }
    }
    //员工离职
    @RequestMapping(value ="/quitStaff",method = RequestMethod.POST)
    public MessageBean quitStaff(StaffBean staffBean){
        int result=staffService.quitStaff(staffBean);

        if (result==1){
            return new MessageBean("succes","添加成功");
        }
        else {
            return new MessageBean("erro","添加失败");
        }
    }


}




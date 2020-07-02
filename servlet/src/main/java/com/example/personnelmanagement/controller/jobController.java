package com.example.personnelmanagement.controller;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.bean.MessageBean;
import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/job")
public class jobController {

    @Autowired
    JobService jobService;

    @RequestMapping(value = "/addJob",method = RequestMethod.POST)
    public MessageBean addJob(String job_name,String max_number,String type_id){

        int maxInt=Integer.parseInt(max_number);
        int typeInt=Integer.parseInt(type_id);

        JobBean jobBean =new JobBean(0,job_name,0,maxInt,typeInt);

        int result= jobService.addJob(jobBean);
        if (result==1){
            return new MessageBean("success","添加成功");
        }
        else {
            return new MessageBean("error","添加失败");
        }
    }

    @RequestMapping(value = "/updateJob",method = RequestMethod.PUT)
    public MessageBean updateJob(String job_id,String job_name,String max_number,String type_id){
        int jobInt=Integer.parseInt(job_id);
        int maxInt=Integer.parseInt(max_number);
        int typeInt=Integer.parseInt(type_id);

        JobBean jobBean =new JobBean(jobInt,job_name,maxInt,typeInt);
        int result = jobService.updateJob(jobBean);

        if (result==1){
            return new MessageBean("success","添加成功");
        }
        else {
            return new MessageBean("error","添加失败");
        }
    }
    @RequestMapping(value = "/deleteJob",method = RequestMethod.DELETE)
    public MessageBean deleteJob(int job_id){
        int check;
        try {
             check= jobService.deleteJob(job_id);
            if (check==1){
                return new MessageBean("success","删除成功");
            }
            else {
                return new MessageBean("error","没有这个岗位");
            }
        }catch (Exception e){
            return new MessageBean("error","岗位下还有员工");
        }



    }

    @RequestMapping(value = "/getJobList")
    public List<Map<String,Object>> getJobList(){
        return jobService.getJobList();
    }

    @RequestMapping(value = "/getJobTypeList")
    public List<Map<String,Object>> getJobTypeList(){
        return jobService.getJobTypeList();
    }

    @RequestMapping(value = "getJobById",method = RequestMethod.GET)
    public JobBean getJobById(String job_id){
        int jobInt=Integer.parseInt(job_id);
        return jobService.getJobById(jobInt);

    }



    @RequestMapping(value = "/selectStaffByJob",method = RequestMethod.GET)
    public List<Map<String,Object>> selectJob(String job_id){

        int jobInt= Integer.parseInt(job_id);

        List<Map<String,Object>> list= jobService.selectStaffByJob(jobInt);
        return list;
    }
}

package com.example.personnelmanagement.controller;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.bean.MessageBean;
import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.mapper.JobMapper;
import com.example.personnelmanagement.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class jobController {

    @Autowired
    JobMapper jobMapper;

    @RequestMapping(value = "/addJob",method = RequestMethod.POST)
    public MessageBean addJob(int job_id,String job_name,int curent_number,int max_number,int type_id){

        JobBean jobBean =new JobBean(job_id,job_name,curent_number,max_number,type_id);

        int result= jobMapper.addJob(jobBean);
        if (result==1){
            return new MessageBean("success","添加成功");
        }
        else {
            return new MessageBean("error","添加失败");
        }
    }

    @RequestMapping(value = "/updateJob",method = RequestMethod.PUT)
    public MessageBean updateJob(int job_id,String job_name,int curent_number,int max_number,int type_id){
        JobBean jobBean =new JobBean(job_id,job_name,curent_number,max_number,type_id);
        int result = jobMapper.updateJob(jobBean);

        if (result==1){
            return new MessageBean("success","添加成功");
        }
        else {
            return new MessageBean("error","添加失败");
        }
    }
    @RequestMapping(value = "/deleteJob",method = RequestMethod.DELETE)
    public MessageBean deleteJob(int job_id){
        int check=jobMapper.deleteCheck(job_id);

        if (check>0){
            return new MessageBean("error","岗位下还有员工");
        }
        else {
            return new MessageBean("success","删除成功");
        }
    }
    @RequestMapping(value = "/selectJob",method = RequestMethod.GET)
    public List<StaffBean> selectJob(@RequestParam("job_id")int job_id){
        List<StaffBean> list=jobMapper.selectStaffByJob(job_id);
        return list;
    }
}

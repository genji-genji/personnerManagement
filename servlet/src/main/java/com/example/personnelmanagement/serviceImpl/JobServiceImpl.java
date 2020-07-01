package com.example.personnelmanagement.serviceImpl;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.mapper.JobMapper;
import com.example.personnelmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobMapper jobMapper;

    @Override
    public int addJob(JobBean jobBean) {
//        因为表已经建成不便修改所以通过max+1获得新id
        jobBean.setJob_id(jobMapper.getMaxId()+1);


        return jobMapper.addJob(jobBean);
    }

    @Override
    public int updateJob(JobBean jobBean) {
        return jobMapper.updateJob(jobBean);
    }

    @Override
    public int deleteJob(int job_id) {
        return jobMapper.deleteJob(job_id);
    }

    @Override
    public List<Map<String,Object>> selectStaffByJob(int job_id) {
        return jobMapper.selectStaffByJob(job_id);
    }

    @Override
    public List<Map<String, Object>> getJobList() {
        return jobMapper.getJobList();
    }
    @Override
    public List<Map<String, Object>> getJobTypeList() {
        return jobMapper.getJobTypeList();
    }

    @Override
    public JobBean getJobById(int job_id) {
        return jobMapper.getJobById(job_id);
    }
}

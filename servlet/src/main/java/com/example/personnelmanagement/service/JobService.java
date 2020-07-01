package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.bean.StaffBean;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface JobService {
    int addJob(JobBean jobBean);
    int updateJob(JobBean jobBean);
    int deleteJob(int job_id);
    JobBean getJobById(int job_id);
    List<Map<String,Object>> getJobList();
    List<Map<String,Object>> getJobTypeList();
    List<Map<String,Object>> selectStaffByJob(int job_id);
}

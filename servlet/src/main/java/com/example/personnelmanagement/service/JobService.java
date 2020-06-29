package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.bean.StaffBean;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
    int addJob(JobBean jobBean);
    int updateJob(JobBean jobBean);
    int deleteJob(int job_id);
    List<StaffBean> selectStaffByJob(int job_id);
}

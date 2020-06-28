package com.example.personnelmanagement.mapper;

import com.example.personnelmanagement.bean.JobBean;
import com.example.personnelmanagement.bean.StaffBean;

import java.util.List;

public interface JobMapper {
    int addJob(JobBean jobBean);
    int updateJob(JobBean jobBean);
    int deleteJob(int job_id);
    int deleteCheck(int job_id);
    List<StaffBean> selectStaffByJob(int job_id);
}

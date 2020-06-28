package com.example.personnelmanagement.bean;

import com.example.personnelmanagement.mapper.JobMapper;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

public class JobBean {
    private int job_id;
    private String job_name;
    private int type_id;
    private int type_name;
    private int current_number;
    private int max_number;

    public JobBean(){

    }
    public JobBean(int job_id,String job_name,int curent_number,int max_number,int type_id){
        this.job_id=job_id;
        this.job_name=job_name;
        this.current_number=curent_number;
        this.max_number=max_number;
        this.type_id=type_id;

    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getType_name() {
        return type_name;
    }

    public void setType_name(int type_name) {
        this.type_name = type_name;
    }

    public int getCurrent_number() {
        return current_number;
    }

    public void setCurrent_number(int current_number) {
        this.current_number = current_number;
    }

    public int getMax_number() {
        return max_number;
    }

    public void setMax_number(int max_number) {
        this.max_number = max_number;
    }
}

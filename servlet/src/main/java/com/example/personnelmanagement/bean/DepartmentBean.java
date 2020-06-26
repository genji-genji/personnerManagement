package com.example.personnelmanagement.bean;


import java.security.PrivateKey;

public class DepartmentBean {
    private int department_id;
    private String department_name;
    private int temp;

    public DepartmentBean(int department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public int getDepartment_id(){
        return department_id;
    }
    public String getDepartment_name(){ return department_name; }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setDepartment_name(String department_name){
        this.department_name = department_name;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString(){
        return ""+this.department_id+" "+this.getDepartment_name();
    }

}

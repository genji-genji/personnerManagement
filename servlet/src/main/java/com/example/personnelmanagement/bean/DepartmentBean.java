package com.example.personnelmanagement.bean;


import java.security.PrivateKey;

public class DepartmentBean {
    private int department_id;
    private String department_name;
    private String department_type;
    private int department_phone;
    private int department_bt;
    private int temp;
    private int type_id;

    public DepartmentBean(int department_id, String department_name,String department_type,int department_phone,int department_bt) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_type = department_type;
        this.department_phone = department_phone;
        this.department_bt = department_bt;
    }
    public DepartmentBean(int department_id, String department_name,String department_type,int department_phone,int department_bt,int type_id) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_type = department_type;
        this.department_phone = department_phone;
        this.department_bt = department_bt;
        this.type_id=type_id;
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

    public String getDepartment_type() {
        return department_type;
    }

    public void setDepartment_type(String department_type) {
        this.department_type = department_type;
    }

    public int getDepartment_phone() {
        return department_phone;
    }

    public void setDepartment_phone(int department_phone) {
        this.department_phone = department_phone;
    }

    public int getDepartment_bt() {
        return department_bt;
    }

    public void setDepartment_bt(int department_bt) {
        this.department_bt = department_bt;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString(){
        return ""+this.department_id+" "+this.department_name+" "+this.department_type+" "+this.department_phone+" "+this.department_bt;
    }

}

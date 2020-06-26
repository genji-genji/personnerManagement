package com.example.personnelmanagement.bean;

public class StaffBean {
    private int sid;
    private String sex;
    private String name;
    private String birthday;
    private String id_no;
    private int department_id;
    private String department_name;
    private int job_id;
    private String job_name;
    private int form_id;
    private String form_name;
    private int origin_id;
    private String origin_name;
    private int statu_id;
    private String statu_name;
    private int jage;

    public StaffBean(int sid,String sex,String name,String birthday,String id_no,
                     int origin_id,int form_id,int department_id,int job_id,int statu_id){
        this.sid=sid;
        this.sex=sex;
        this.name=name;
        this.birthday=birthday;
        this.id_no=id_no;
        this.origin_id=origin_id;
        this.form_id=form_id;
        this.department_id=department_id;
        this.job_id=job_id;
        this.statu_id=statu_id;

    }
    public StaffBean(){

    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getForm_name() {
        return form_name;
    }

    public void setForm_name(String form_name) {
        this.form_name = form_name;
    }

    public int getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(int origin_id) {
        this.origin_id = origin_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public int getStatu_id() {
        return statu_id;
    }

    public void setStatu_id(int statu_id) {
        this.statu_id = statu_id;
    }

    public String getStatu_name() {
        return statu_name;
    }

    public void setStatu_name(String statu_name) {
        this.statu_name = statu_name;
    }

    public int getJage() {
        return jage;
    }

    public void setJage(int jage) {
        this.jage = jage;
    }

    @Override
    public String toString(){
        return ""+this.sid+" "+this.sex+" "+this.name+""+this.origin_name;
    }
}

package com.example.personnelmanagement.bean;

public class StaffBean {
    private int sid;  //id
    private String sex; //性别
    private String name; //姓名
    private String birthday; //出生日期
    private String id_no; //身份证号
    private int department_id; //部门id
    private String department_name; //部门名
    private int job_id; //岗位id
    private String job_name; //岗位名
    private int form_id; //入工形式id
    private String form_name; //入工形式名
    private int origin_id; //招聘方式id
    private String origin_name; //招聘方式
    private int statu_id; //状态码
    private String statu_name; //状态
    private int last; //试用期长度
    private int jage; //插入，更新，删除，返回判断码

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

    public StaffBean(int sid,String sex,String name,String birthday,String id_no,
                     int origin_id,int form_id,int department_id,int job_id,int statu_id,int last){
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
        this.last=last;

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

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    @Override
    public String toString(){
        return ""+this.sid+" "+this.sex+" "+this.name+" "+this.origin_name+" "+form_name
                +" "+department_name+" "+job_name+" "+statu_name;
    }
}

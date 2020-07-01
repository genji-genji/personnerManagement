package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.DepartmentBean;
import com.example.personnelmanagement.bean.StaffBean;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    DepartmentBean getDepartment_id(int department_id);
    DepartmentBean getDepartment_name(String department_name);
    DepartmentBean getDepartment_type(String department_type);
    DepartmentBean getDepartment_phone(int department_phone);
    DepartmentBean getDepartment_bt(int department_bt);
    int addDepartment(DepartmentBean departmentBean);
    int changeDepartment(int department_id, String department_name, String department_type, int department_phone, int department_bt );
    DepartmentBean deleteDepartment(int department_id);
    int deleteCheck(int department_id);
    List<StaffBean> SelectByDepartment (int department_id);
    List<Map<String,Object>> getDepartmentList();
}

package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.DepartmentBean;

public interface DepartmentService {
    DepartmentBean getDepartment_id(int department_id);
    DepartmentBean getDepartment_name(String department_name);
    DepartmentBean getDepartment_type(String department_type);
    DepartmentBean getDepartment_phone(int department_phone);
    DepartmentBean getDepartment_bt(int department_bt);
    int addDepartment(DepartmentBean departmentBean);
}

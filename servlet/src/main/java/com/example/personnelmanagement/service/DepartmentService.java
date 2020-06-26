package com.example.personnelmanagement.service;

import com.example.personnelmanagement.bean.DepartmentBean;

public interface DepartmentService {
    DepartmentBean getDepartment_id(int department_id);
    DepartmentBean getDepartment_name(String department_name);
    int addDepartment(DepartmentBean departmentBean);
}

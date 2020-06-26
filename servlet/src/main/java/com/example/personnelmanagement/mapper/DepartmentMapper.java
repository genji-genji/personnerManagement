package com.example.personnelmanagement.mapper;

import com.example.personnelmanagement.bean.DepartmentBean;

public interface DepartmentMapper {
    DepartmentBean getDepartment_id(int department_id);
    DepartmentBean getDepartment_name(String department_name);
    int addDepartment(DepartmentBean departmentBean);

    int getMaxId();

}


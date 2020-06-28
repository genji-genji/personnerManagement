package com.example.personnelmanagement.serviceImpl;

import com.example.personnelmanagement.bean.DepartmentBean;
import com.example.personnelmanagement.mapper.DepartmentMapper;
import com.example.personnelmanagement.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public DepartmentBean getDepartment_id(int department_id) {
        return departmentMapper.getDepartment_id(department_id);
    }

    @Override
    public DepartmentBean getDepartment_name(String department_name) {
        return departmentMapper.getDepartment_name(department_name);
    }

    @Override
    public DepartmentBean getDepartment_type(String department_type) {
        return departmentMapper.getDepartment_type(department_type);
    }

    @Override
    public DepartmentBean getDepartment_phone(int department_phone) {
        return departmentMapper.getDepartment_phone(department_phone);
    }

    @Override
    public DepartmentBean getDepartment_bt(int department_bt) {
        return departmentMapper.getDepartment_bt(department_bt);
    }

    @Override
    public int addDepartment(DepartmentBean departmentBean) {
        // int temp;
        // departmentBean.setDepartment_id(departmentMapper.getMaxId()+1);
        // departmentMapper.addDepartment(departmentBean);
        // temp=departmentBean.getTemp();
        return departmentMapper.addDepartment(departmentBean);
    }

    @Override
    public DepartmentBean changeDepartment(int department_id, String department_name, String department_type, int department_phone, int department_bt ){
        return departmentMapper.changeDepartment(department_id,department_name,department_type,department_phone,department_bt);
    }


}

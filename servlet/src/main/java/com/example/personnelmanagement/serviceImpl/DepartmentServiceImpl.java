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
    public int addDepartment(DepartmentBean departmentBean) {
        // int temp;
        // departmentBean.setDepartment_id(departmentMapper.getMaxId()+1);
        // departmentMapper.addDepartment(departmentBean);
        // temp=departmentBean.getTemp();
        return departmentMapper.addDepartment(departmentBean);
    }


}

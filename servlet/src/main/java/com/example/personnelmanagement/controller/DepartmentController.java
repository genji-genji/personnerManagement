package com.example.personnelmanagement.controller;

import com.example.personnelmanagement.bean.DepartmentBean;
import com.example.personnelmanagement.bean.MessageBean;
import com.example.personnelmanagement.bean.StaffBean;
import com.example.personnelmanagement.mapper.DepartmentMapper;
import com.example.personnelmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.EOFException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;
    DepartmentService departmentService;

    @RequestMapping(value = "/addDepartment" ,method = RequestMethod.POST)

    public MessageBean addDepartment (int department_id,String department_name,String department_type,int department_phone,int department_bt){
        DepartmentBean departmentBean = new DepartmentBean(department_id,department_name,department_type,department_phone,department_bt);
        int result = departmentMapper.addDepartment(departmentBean);
        if (result==1){
            return new MessageBean("success","添加成功");
        }
        else {
            return new MessageBean("error","添加失败");
        }
    }

    @RequestMapping(value = "/changeDepartment",method = RequestMethod.POST)

    public MessageBean changeDepartment (int department_id,String department_name,String department_type,int department_phone,int department_bt) {
        int result = departmentMapper.changeDepartment(department_id, department_name, department_type, department_phone, department_bt);
        if (result == 1) {
            return new MessageBean("success", "添加成功");
        } else {
            return new MessageBean("error", "添加失败");
        }
    }

    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.POST)
    public MessageBean deleteDepartment (int department_id) {
        int check = departmentMapper.deleteCheck(department_id);

        if (check > 0) {
            return new MessageBean("error", "部门下还有员工");
        } else {
            return new MessageBean("success", "删除成功");
        }
    }

    @RequestMapping(value = "/SelectByDepartment",method = RequestMethod.GET)
    public List<StaffBean> selectByDepartment(@RequestParam("department_id")int department_id){
        List<StaffBean> list=departmentMapper.SelectByDepartment(department_id);
        return list;
    }
    @RequestMapping("/getDepartmentList")
    public List<Map<String,Object>> getDepartment(){
        return departmentMapper.getDepartmentList();
    }


}

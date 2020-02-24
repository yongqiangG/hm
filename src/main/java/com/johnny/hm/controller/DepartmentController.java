package com.johnny.hm.controller;

import com.johnny.hm.bean.Department;
import com.johnny.hm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/basic/dep")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public List<Department> getDepTree(){
        return departmentService.getDepTree();
    }
}

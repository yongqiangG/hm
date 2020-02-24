package com.johnny.hm.service;

import com.johnny.hm.bean.Department;
import com.johnny.hm.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getDepTree() {
        return departmentMapper.getDepTree();
    }
}

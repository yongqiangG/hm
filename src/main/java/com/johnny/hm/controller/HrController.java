package com.johnny.hm.controller;

import com.johnny.hm.bean.Hr;
import com.johnny.hm.service.HrService;
import com.johnny.hm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    //获取全部登录角色,除自己
    @GetMapping("/")
    public List<Hr> getAllHrs(){
        return hrService.getAllHrs();
    }
}

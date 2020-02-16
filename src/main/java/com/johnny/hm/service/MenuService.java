package com.johnny.hm.service;

import com.johnny.hm.bean.Hr;
import com.johnny.hm.bean.Menu;
import com.johnny.hm.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getMenusById() {
        return menuMapper.getMenusById(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
    //TODO 这个获取菜单可以使用缓存操作,保存到redis,节省数据库操作开销
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }
}

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
}

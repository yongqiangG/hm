package com.johnny.hm.service;

import com.johnny.hm.bean.Hr;
import com.johnny.hm.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    //根据用户名从数据库获取记录并映射到hr对象,可以获取到账号信息,账号角色,账号状态
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if(hr==null){
            throw new UsernameNotFoundException("账号不存在");
        }
        return hr;
    }
}

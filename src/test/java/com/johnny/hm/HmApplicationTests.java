package com.johnny.hm;

import com.johnny.hm.bean.Role;
import com.johnny.hm.mapper.HrMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HmApplicationTests {
    @Autowired
    HrMapper hrMapper;
    @Test
    public void bCry(){
        PasswordEncoder pwe = new BCryptPasswordEncoder();
        String[] strings = new String[10];
        for (int i = 0; i < 10; i++) {
            String encode = pwe.encode("chenxiaomin");
            System.out.println(encode);
            strings[i] = encode;
        }
    }
    @Test
    public void getRolesByHrId(){
        List<Role> roles = hrMapper.getRolesById(10);
        for (Role role : roles) {
            System.out.println(role.getName());
        }
    }


    @Test
    public void contextLoads() {
    }

}

package com.johnny.hm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnny.hm.bean.Hr;
import com.johnny.hm.model.RespBean;
import com.johnny.hm.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;
    @Bean
    //使用spring security的加密工具BCryptPasswordEncoder,相同密码可以加密成不同的密码
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //认证所有请求
                .anyRequest().authenticated()
                .and()
                //定义表单提交的name属性
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                //处理登录的请求
                .loginProcessingUrl("/doLogin")
                //登录页面设置
                .loginPage("/login")
                //认证成功回调
                .successHandler(new AuthenticationSuccessHandler() {
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        //登录成功处理,返回一个json字符串
                        resp.setContentType("application/json;charset=utf-8");
                        Hr hr = (Hr) authentication.getPrincipal();
                        RespBean respBean = new RespBean(200, "登录成功", hr);
                        hr.setPassword(null);
                        PrintWriter pw = resp.getWriter();
                        pw.write(new ObjectMapper().writeValueAsString(respBean));
                        pw.flush();
                        pw.close();
                    }
                })
                //认证失败回调
                .failureHandler(new AuthenticationFailureHandler() {
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
                        //登陆失败,返回登录失败信息
                        resp.setContentType("application/json;charset=utf-8");
                        RespBean respBean = RespBean.err("登陆失败");
                        if(exception instanceof AccountExpiredException){
                            respBean.setMsg("账号过期");
                        }else if(exception instanceof LockedException){
                            respBean.setMsg("账号被锁定");
                        }else if(exception instanceof CredentialsExpiredException){
                            respBean.setMsg("密码过期");
                        }else if(exception instanceof DisabledException){
                            respBean.setMsg("账号被禁用");
                        }else if(exception instanceof BadCredentialsException){
                            respBean.setMsg("账号或密码错误");
                        }
                        PrintWriter pw = resp.getWriter();
                        pw.write(new ObjectMapper().writeValueAsString(respBean));
                        pw.flush();
                        pw.close();
                    }
                })
                .permitAll()
                .and()
                //处理注销请求
                .logout()
                //注销请求成功回调
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        //注销处理
                        resp.setContentType("application/json;charset=utf-8");
                        RespBean respBean = RespBean.ok("注销成功");
                        PrintWriter pw = resp.getWriter();
                        pw.write(new ObjectMapper().writeValueAsString(respBean));
                        pw.flush();
                        pw.close();
                    }
                })
                .permitAll();
        //关闭跨域保护,方便postman测试
        http.csrf().disable();
    }
}
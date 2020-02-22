package com.johnny.hm.exception;

import com.johnny.hm.model.RespBean;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean SQLExceptionHandler(SQLException e){
        if(e instanceof MySQLIntegrityConstraintViolationException){
            return  RespBean.err("该数据已被引用,删除失败");
        }
        return RespBean.err("数据库异常,操作失败");
    }

}

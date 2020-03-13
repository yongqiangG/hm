package com.johnny.hm.mapper;


import com.johnny.hm.bean.ModuleType;

public interface ModuleTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModuleType record);

    int insertSelective(ModuleType record);

    ModuleType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModuleType record);

    int updateByPrimaryKey(ModuleType record);
}
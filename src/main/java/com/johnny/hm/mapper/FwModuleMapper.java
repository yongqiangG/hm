package com.johnny.hm.mapper;


import com.johnny.hm.bean.FwModule;

public interface FwModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FwModule record);

    int insertSelective(FwModule record);

    FwModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FwModule record);

    int updateByPrimaryKey(FwModule record);
}
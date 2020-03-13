package com.johnny.hm.mapper;


import com.johnny.hm.bean.FwInfo;

public interface FwInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FwInfo record);

    int insertSelective(FwInfo record);

    FwInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FwInfo record);

    int updateByPrimaryKey(FwInfo record);
}
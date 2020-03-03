package com.johnny.hm.mapper;


import com.johnny.hm.bean.RoomType;

public interface RoomTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
}
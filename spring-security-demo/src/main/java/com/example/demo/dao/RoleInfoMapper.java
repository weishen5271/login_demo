package com.example.demo.dao;

import com.example.demo.entity.RoleInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);
}
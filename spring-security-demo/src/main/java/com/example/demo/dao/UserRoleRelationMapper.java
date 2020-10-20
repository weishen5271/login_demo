package com.example.demo.dao;

import com.example.demo.entity.UserRoleRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleRelation record);

    int insertSelective(UserRoleRelation record);

    UserRoleRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleRelation record);

    int updateByPrimaryKey(UserRoleRelation record);
}
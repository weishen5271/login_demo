package com.example.demo.dao;

import com.example.demo.entity.RolePermissionRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissionRelation record);

    int insertSelective(RolePermissionRelation record);

    RolePermissionRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermissionRelation record);

    int updateByPrimaryKey(RolePermissionRelation record);
}
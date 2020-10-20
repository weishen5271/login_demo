package com.example.demo.service.impl;

import com.example.demo.dao.PermissionMapper;
import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/10/19 0019 16:28。</p>
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectListByUser(Integer userId) {
        return permissionMapper.selectListByUser(userId);
    }

    @Override
    public List<Permission> selectListByPath(String path) {
        List<Permission> permissions = permissionMapper.selectListByPath(path);
        return permissions;
    }
}

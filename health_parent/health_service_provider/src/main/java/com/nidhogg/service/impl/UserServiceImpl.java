package com.nidhogg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nidhogg.dao.PermissionDao;
import com.nidhogg.dao.RoleDao;
import com.nidhogg.dao.UserDao;
import com.nidhogg.pojo.Permission;
import com.nidhogg.pojo.Role;
import com.nidhogg.pojo.User;
import com.nidhogg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Nidhogg on 2021/8/21.
 */
@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    //根据用户名查询用户信息及关联的角色信息，同时查询角色关联的权限信息
    public User findByUsername(String username) {
        //查找用户基本信息
        User user = userDao.findByUsername(username);
        if(user == null){
            return null;
        }
        Integer userId = user.getId();
        //根据用户名查询角色信息
        Set<Role> roles = roleDao.findByUserId(userId);
        if(roles != null && roles.size() > 0){
            for(Role role : roles){
                Integer roleId = role.getId();
                //根据角色信息查询权限信息
                Set<Permission> permissions = permissionDao.findByRoleId(roleId);
                if(permissions != null && permissions.size() > 0){
                    role.setPermissions(permissions);
                }
            }
            user.setRoles(roles);
        }
        return user;
    }
}
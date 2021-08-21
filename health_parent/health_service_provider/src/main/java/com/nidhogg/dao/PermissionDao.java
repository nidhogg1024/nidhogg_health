package com.nidhogg.dao;

import com.nidhogg.pojo.Permission;

import java.util.Set;

/**
 * Created by Nidhogg on 2021/8/21.
 */
public interface PermissionDao {
    Set<Permission> findByRoleId(Integer roleId);
}

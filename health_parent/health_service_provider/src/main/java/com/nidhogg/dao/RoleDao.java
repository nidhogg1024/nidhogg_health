package com.nidhogg.dao;

import com.nidhogg.pojo.Role;

import java.util.Set;

/**
 * Created by Nidhogg on 2021/8/21.
 */
public interface RoleDao {
    Set<Role> findByUserId(Integer userId);
}

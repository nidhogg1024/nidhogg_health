package com.nidhogg.dao;

import com.nidhogg.pojo.User;

/**
 * Created by Nidhogg on 2021/8/21.
 */
public interface UserDao {
    User findByUsername(String username);
}

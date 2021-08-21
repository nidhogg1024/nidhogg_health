package com.nidhogg.service;

import com.nidhogg.pojo.User;

/**
 * Created by Nidhogg on 2021/8/21.
 */
public interface UserService {
    User findByUsername(String username);
}

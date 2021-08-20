package com.nidhogg.service;


import com.nidhogg.entity.Result;

import java.util.Map;

public interface OrderService {
    //体检预约
    Result order(Map map) throws Exception;

    Map findById(Integer id) throws Exception;
}

package com.nidhogg.service;

import com.nidhogg.entity.Result;

/**
 * Created by Nidhogg on 2021/8/28.
 */
public interface SendValidataCode {
    Result send(String account, String validateCode);
}

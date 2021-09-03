package com.nidhogg.controller;


import com.nidhogg.entity.Result;
import com.nidhogg.utils.SendMailUtils;
import com.nidhogg.service.SendValidataCode;


/**
 * Created by Nidhogg on 2021/9/3.
 */
public class SendMailController implements SendValidataCode {
    @Override
    public Result send(String account, String validateCode){
        SendMailUtils.sendMail(account,validateCode);
        return null;
    }
}

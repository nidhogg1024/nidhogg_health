package com.nidhogg.controller;

import com.aliyuncs.exceptions.ClientException;
import com.nidhogg.constant.MessageConstant;
import com.nidhogg.entity.Result;
import com.nidhogg.utils.SMSUtils;
import com.nidhogg.service.SendValidataCode;

/**
 * Created by Nidhogg on 2021/9/3.
 */
public class SMSController implements SendValidataCode{
    @Override
    public Result send(String account, String validateCode) {
        try {
            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,account,validateCode);
        } catch (ClientException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        return null;
    }
}

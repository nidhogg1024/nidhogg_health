package com.nidhogg.service;

import com.nidhogg.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * Created by Nidhogg on 2021/8/20.
 */
public interface OrderSettingService {
    void add(List<OrderSetting> orderSettingList);

    List<Map> getOrderSettingByMonth(String date);

    void editNumberByDate(OrderSetting orderSetting);
}

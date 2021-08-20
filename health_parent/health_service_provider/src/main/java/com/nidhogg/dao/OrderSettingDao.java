package com.nidhogg.dao;

import com.nidhogg.pojo.OrderSetting;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderSettingDao {
    void add(OrderSetting orderSetting);

    //更新可预约人数
    void editNumberByOrderDate(OrderSetting orderSetting);

    //更新已预约人数
    void editReservationsByOrderDate(OrderSetting orderSetting);

    long findCountByOrderDate(Date orderDate);

    //根据日期范围查询预约设置信息
    List<OrderSetting> getOrderSettingByMonth(Map date);

    //根据预约日期查询预约设置信息
    OrderSetting findByOrderDate(Date orderDate);
}

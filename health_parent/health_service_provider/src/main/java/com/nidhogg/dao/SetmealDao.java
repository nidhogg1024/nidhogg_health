package com.nidhogg.dao;

import com.github.pagehelper.Page;
import com.nidhogg.pojo.CheckItem;
import com.nidhogg.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * Created by Nidhogg on 2021/8/20.
 */
public interface SetmealDao {
    void add(Setmeal setmeal);

    void setSetmealAndCheckGroup(Map<String, Integer> map);

    Page<CheckItem> selectByCondition(String queryString);

    List<Setmeal> findAll();

    Setmeal findById(int id);
}

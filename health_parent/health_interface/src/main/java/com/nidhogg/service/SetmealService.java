package com.nidhogg.service;

import com.nidhogg.entity.PageResult;
import com.nidhogg.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * Created by Nidhogg on 2021/8/20.
 */
public interface SetmealService {
    void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    List<Setmeal> findAll();

    Setmeal findById(int id);

    List<Map<String,Object>> findSetmealCount();
}

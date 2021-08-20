package com.nidhogg.service;

import com.nidhogg.entity.PageResult;
import com.nidhogg.entity.QueryPageBean;
import com.nidhogg.pojo.CheckGroup;

import java.util.List;

/**
 * Created by Nidhogg on 2021/8/19.
 */
public interface CheckGroupService {
    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    PageResult findPage(QueryPageBean queryPageBean);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    void delete(Integer id);

    List<CheckGroup> findAll();
}

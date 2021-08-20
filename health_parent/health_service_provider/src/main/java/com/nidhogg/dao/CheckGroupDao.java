package com.nidhogg.dao;

import com.github.pagehelper.Page;
import com.nidhogg.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by Nidhogg on 2021/8/19.
 */
public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    void setCheckGroupAndCheckItem(Map map);

    Page<CheckGroup> selectByCondition(String queryString);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void edit(CheckGroup checkGroup);

    void deleteAssociation(Integer id);

    void delete(Integer id);

    List<CheckGroup> findAll();
}

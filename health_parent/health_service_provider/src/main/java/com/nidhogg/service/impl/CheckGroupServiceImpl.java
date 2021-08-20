package com.nidhogg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nidhogg.dao.CheckGroupDao;
import com.nidhogg.entity.PageResult;
import com.nidhogg.entity.QueryPageBean;
import com.nidhogg.pojo.CheckGroup;
import com.nidhogg.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nidhogg on 2021/8/19.
 */
@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;

    @Override
    //新增检查组，同时关联检查项
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        //新增检查组
        checkGroupDao.add(checkGroup);
        //设置关联关系
        Integer checkGroupId = checkGroup.getId();
        this.setCheckGroupAndCheckItem(checkGroupId,checkitemIds);
    }

    @Override
    //分页查询检查组
    public PageResult findPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckGroup> page = checkGroupDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<CheckGroup> rows = page.getResult();
        return new PageResult(total,rows);
    }

    @Override
    //根据Id查询检查组
    public CheckGroup findById(Integer id) {
        CheckGroup checkGroup=checkGroupDao.findById(id);
        return checkGroup;
    }

    @Override
    //根据检查组ID查询检查项ID
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id) {
        List<Integer> checkItemIds=checkGroupDao.findCheckItemIdsByCheckGroupId(id);
        return checkItemIds;
    }

    @Override
    //编辑检查组信息
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
        //修改检查组基本信息
        checkGroupDao.edit(checkGroup);
        //删除之前的关联关系
        Integer checkGroupId = checkGroup.getId();
        this.deleteAssociation(checkGroupId);
        //重新建立关联关系
        this.setCheckGroupAndCheckItem(checkGroupId,checkitemIds);
    }

    @Override
    //删除检查组
    public void delete(Integer id) {
        //删除关联关系
        this.deleteAssociation(id);
        //删除检查组
        checkGroupDao.delete(id);
    }

    @Override
    public List<CheckGroup> findAll() {
        List<CheckGroup> checkGroups=checkGroupDao.findAll();
        return checkGroups;
    }

    //删除检查组和检查项关联关系
    private void deleteAssociation(Integer checkGroupId){
        checkGroupDao.deleteAssociation(checkGroupId);
    }
    //建立检查组和检查项关联关系
    private void setCheckGroupAndCheckItem(Integer checkGroupId,Integer[] checkitemIds){
        if(checkitemIds != null && checkitemIds.length > 0){
            for (Integer checkitemId : checkitemIds) {
                Map<String,Integer> map = new HashMap<>();
                map.put("checkgroup_id",checkGroupId);
                map.put("checkitem_id",checkitemId);
                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }
    }
}

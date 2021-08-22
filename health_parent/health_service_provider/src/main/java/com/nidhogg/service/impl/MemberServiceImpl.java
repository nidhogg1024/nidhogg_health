package com.nidhogg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nidhogg.dao.MemberDao;
import com.nidhogg.pojo.Member;
import com.nidhogg.service.MemberService;
import com.nidhogg.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nidhogg on 2021/8/21.
 */
@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl  implements MemberService{
    @Autowired
    private MemberDao memberDao;

    //根据手机号查询会员
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }

    @Override
    //根据月份统计会员数量
    public List<Integer> findMemberCountByMonth(List<String> month) {
        List<Integer> list = new ArrayList<>();
        for(String m : month){
            m = m + ".31";//格式：2019.04.31
            Integer count = memberDao.findMemberCountBeforeDate(m);
            list.add(count);
        }
        return list;
    }

    //新增会员
    public void add(Member member) {
        if(member.getPassword() != null){
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }
}

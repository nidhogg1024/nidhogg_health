package com.nidhogg.service;

import com.nidhogg.pojo.Member;

import java.util.List;


public interface MemberService {
    void add(Member member);
    Member findByTelephone(String telephone);

    List<Integer> findMemberCountByMonth(List<String> list);
}

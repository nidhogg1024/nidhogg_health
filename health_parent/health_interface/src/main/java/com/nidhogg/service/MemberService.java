package com.nidhogg.service;

import com.nidhogg.pojo.Member;

/**
 * Created by Nidhogg on 2021/8/21.
 */
public interface MemberService {
    void add(Member member);
    Member findByTelephone(String telephone);
}

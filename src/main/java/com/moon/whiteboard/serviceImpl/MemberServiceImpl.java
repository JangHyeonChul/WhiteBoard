package com.moon.whiteboard.serviceImpl;

import com.moon.whiteboard.dto.Member;

import com.moon.whiteboard.mapper.MemberMapper;
import com.moon.whiteboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public void save(Member member) {
        memberMapper.saveMember(member);
    }

    @Override
    public Member findEmail(String email) {
         return memberMapper.findByEmail(email);
    }




}

package com.moon.whiteboard.Service;

import com.moon.whiteboard.dto.Member;

import com.moon.whiteboard.mapperdao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDAO memberDAO;

    @Override
    public void save(Member member) {
        memberDAO.saveMember(member);
    }

    @Override
    public Member findEmail(String email) {
         return memberDAO.findByEmail(email);
    }




}

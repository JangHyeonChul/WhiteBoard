package com.moon.whiteboard.Service;


import com.moon.whiteboard.dto.Member;
import org.springframework.stereotype.Service;


public interface MemberService {
    void save(Member member);
    Member findEmail(String email);

}

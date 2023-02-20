package com.moon.whiteboard;


import com.moon.whiteboard.service.MemberService;
import com.moon.whiteboard.dto.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test1 {

    @Autowired
    MemberService memberService;



    @Test
    public void 회원가입() {
        Member member = new Member(1,"asdf", "asdf", "asdf", null, null,  1);
        memberService.save(member);



    }

    @Test
    public void 이메일로찾기() {
        Member email = memberService.findEmail("wkdgus1136@naver.com");
        System.out.println("email = " + email);
    }
}

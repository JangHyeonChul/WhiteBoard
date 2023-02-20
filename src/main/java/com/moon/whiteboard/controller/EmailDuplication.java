package com.moon.whiteboard.controller;

import com.moon.whiteboard.service.MemberService;
import com.moon.whiteboard.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailDuplication {

    @Autowired
    MemberService memberService;

    @PostMapping("/emailduplication")
    @ResponseBody
    public String emailDuplicationCheck(String emailValue) {
        Member email = memberService.findEmail(emailValue);

        if(email == null) {
            return "true";
        }
        return "false";
    }
}

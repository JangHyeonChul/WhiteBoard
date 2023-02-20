package com.moon.whiteboard.Controller;


import com.moon.whiteboard.Service.EmailService;
import com.moon.whiteboard.Service.MemberService;
import com.moon.whiteboard.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/member")
public class RegisterController {

    @Autowired
    MemberService memberService;

    @Autowired
    EmailService emailService;


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String test2(String email) {
        int result = emailService.sendEmail(email);
        return Integer.toString(result);
    }


    @PostMapping("/submitRegister")
    public String test3(@ModelAttribute("member") Member member) {
        memberService.save(member);
        return "redirect:/";
    }
}

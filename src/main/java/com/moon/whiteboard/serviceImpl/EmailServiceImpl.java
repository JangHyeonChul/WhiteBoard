package com.moon.whiteboard.serviceImpl;

import com.moon.whiteboard.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public int sendEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        int RandomNum = RandomNum();

        message.setSubject("제목");
        message.setText("인증번호 " + RandomNum + " 입니다");
        message.setFrom("wkdgus1136@gmail.com");
        message.setTo(email);
        mailSender.send(message);

        return RandomNum;
    }

    public int RandomNum() {
        Random random = new Random();
        int RandomNum = random.nextInt(888888) + 111111;
        return RandomNum;

    }
}

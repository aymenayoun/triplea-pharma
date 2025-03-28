package com.ayouni.tripleA.Pharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String toEmail, String verificationLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("support@trial-3yxj6ljr62x4do2r.mlsender.net"); // Replace with your verified sender email
        message.setTo(toEmail);
        message.setSubject("Verify your email");
        message.setText("Please click the link to verify your email: " + verificationLink);

        mailSender.send(message);
    }
}
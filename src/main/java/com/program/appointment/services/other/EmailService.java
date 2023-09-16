package com.program.appointment.services.other;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String msg){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try{
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(msg);
            helper.setFrom("sameerlamaz99@gmail.com");
            javaMailSender.send(message);

        }catch (Exception e){
        }

    }
}

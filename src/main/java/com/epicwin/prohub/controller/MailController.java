package com.epicwin.prohub.controller;

import com.epicwin.prohub.model.email.Mail;
import com.epicwin.prohub.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/email")
    public void sendEmail() {

        Mail mail = new Mail();
        mail.setMailFrom("");
        mail.setMailTo("");
        mail.setMailSubject("");
        mail.setMailContent("");

        mailService.sendEmail(mail);
    }
}

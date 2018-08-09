package com.project.controller;

import com.project.utils.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailSenderController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public String sendMail(){
        emailService.sendSimpleMail("xxxxx@gmail.com","FirstMail", "Lorem ipsum.");
        return "send";
    }
}

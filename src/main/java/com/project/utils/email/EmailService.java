package com.project.utils.email;

import javax.mail.MessagingException;

public interface EmailService {

    void sendSimpleMail(String to, String subject, String text);

    void sendMailWithAttachment(String to,String subject, String text, String pathToAttachment) throws MessagingException;
}

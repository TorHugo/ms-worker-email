package com.dev.torhugo.ms.worker.email.application.usecase;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.logging.Logger;

public class SendEmailUseCase {
    private final Logger log = Logger.getLogger(getClass().getName());
    private final JavaMailSender javaMailSender;

    public SendEmailUseCase(final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void execute(final SimpleMailMessage message){
        log.info("Executing usecase: SendEmail().");
        javaMailSender.send(message);
    }
}

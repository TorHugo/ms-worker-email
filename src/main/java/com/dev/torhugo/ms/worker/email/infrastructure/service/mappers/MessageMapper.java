package com.dev.torhugo.ms.worker.email.infrastructure.service.mappers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    @Value("${internal.default.email}")
    private String emailFrom;

    public SimpleMailMessage buildMessage(final String emailTo,
                                          final String subject,
                                          final String text){
        final var message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(emailTo);
        message.setSubject(subject);
        message.setText(replaceNewlineCharacters(text));
        return message;
    }

    private String replaceNewlineCharacters(final String input){
        return input.replace("\\n", System.lineSeparator());
    }
}

package com.dev.torhugo.ms.worker.email.service.impl;

import com.dev.torhugo.ms.worker.email.domain.dto.LoggerErrorDTO;
import com.dev.torhugo.ms.worker.email.domain.dto.TemplateEmailDTO;
import com.dev.torhugo.ms.worker.email.service.LoggerErrorService;
import com.dev.torhugo.ms.worker.email.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendEmailServiceImpl implements SendEmailService {
    private final JavaMailSender javaMailSender;
    private final LoggerErrorService loggerErrorService;
    @Override
    public void execute(final String emailTo,
                        final TemplateEmailDTO template) {
        try {
            final SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("contato.arrudavictor@gmail.com");
            message.setTo(emailTo);
            message.setSubject(template.subject());
            message.setText(template.text());
            javaMailSender.send(message);
        } catch (final MailException exception){
            log.error("[ERROR] - Exception in send email.");
            loggerErrorService.save(new LoggerErrorDTO(emailTo, "ms-worker-email", "send-email", exception.getMessage()));
        }
    }
}

package com.dev.torhugo.ms.worker.email.infrastructure.config.usecase;

import com.dev.torhugo.ms.worker.email.application.usecase.SendEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@RequiredArgsConstructor
public class SendEmailUseCaseConfig {
    private final JavaMailSender javaMailSender;
    @Bean
    public SendEmailUseCase sendEmailUseCase(){
        return new SendEmailUseCase(javaMailSender);
    }
}

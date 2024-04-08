package com.dev.torhugo.ms.worker.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class BeanConfig {
    @Value("${integration.email.host}")
    private String host;
    @Value("${integration.email.port}")
    private Integer port;
    @Value("${integration.email.username}")
    private String username;
    @Value("${integration.email.password}")
    private String password;

    @Bean
    public JavaMailSender javaMailSender() {
        final var mail = new JavaMailSenderImpl();
        mail.setHost(host);
        mail.setPort(port);
        mail.setUsername(username);
        mail.setPassword(password);
        final var props = mail.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return mail;
    }
}

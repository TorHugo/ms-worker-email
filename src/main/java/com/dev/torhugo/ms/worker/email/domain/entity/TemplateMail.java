package com.dev.torhugo.ms.worker.email.domain.entity;

import com.dev.torhugo.ms.worker.email.domain.vo.Message;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class TemplateMail {
    private final UUID templateId;
    private final String process;
    private final Message message;
    private final boolean active;
    private final boolean email;
    private final boolean sms;
    private final boolean whatsapp;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private TemplateMail(final UUID templateId,
                         final String process,
                         final String subject,
                         final String introduction,
                         final String body,
                         final String conclusion,
                         final String signature,
                         final boolean active,
                         final boolean email,
                         final boolean sms,
                         final boolean whatsapp,
                         final LocalDateTime createdAt,
                         final LocalDateTime updatedAt) {
        this.templateId = templateId;
        this.process = process;
        this.message = new Message(subject, introduction, body, conclusion, signature);
        this.active = active;
        this.email = email;
        this.sms = sms;
        this.whatsapp = whatsapp;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TemplateMail restore(final UUID templateId,
                                       final String process,
                                       final String subject,
                                       final String introduction,
                                       final String body,
                                       final String conclusion,
                                       final String signature,
                                       final boolean active,
                                       final boolean email,
                                       final boolean sms,
                                       final boolean whatsapp,
                                       final LocalDateTime createdAt,
                                       final LocalDateTime updatedAt){
        return new TemplateMail(
                templateId,
                process,
                subject,
                introduction,
                body,
                conclusion,
                signature,
                active,
                email,
                sms,
                whatsapp,
                createdAt,
                updatedAt
        );
    }
}

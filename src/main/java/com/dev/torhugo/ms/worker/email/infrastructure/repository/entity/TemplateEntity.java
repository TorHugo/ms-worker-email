package com.dev.torhugo.ms.worker.email.infrastructure.repository.entity;

import com.dev.torhugo.ms.worker.email.domain.entity.TemplateMail;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Entity(name = "template_tb")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TemplateEntity {
    @Id
    private UUID templateId;
    private String process;
    private String subject;
    private String introduction;
    private String body;
    private String conclusion;
    private String signature;
    private boolean active;
    private boolean email;
    private boolean whatsapp;
    private boolean sms;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TemplateMail toAggregate(final TemplateEntity entity){
        return TemplateMail.restore(
                entity.templateId,
                entity.process,
                entity.subject,
                entity.introduction,
                entity.body,
                entity.conclusion,
                entity.signature,
                entity.active,
                entity.email,
                entity.sms,
                entity.whatsapp,
                entity.createdAt,
                entity.updatedAt
        );
    }
}

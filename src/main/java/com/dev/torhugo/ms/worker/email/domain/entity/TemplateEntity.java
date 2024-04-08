package com.dev.torhugo.ms.worker.email.domain.entity;

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
    private String queue;
    private String template;
    private String subject;
    private String account;
    private boolean active;
    private boolean email;
    private boolean sms;
    private boolean whatsapp;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

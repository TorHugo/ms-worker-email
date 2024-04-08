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
@Entity(name = "logger_error")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class LoggerErrorEntity {
    @Id
    private UUID loggerErrorId;
    private String identifier;
    private String application;
    private String process;
    private String error;
    private LocalDateTime createdAt;

    public static LoggerErrorEntity create(
            final String identifier,
            final String application,
            final String process,
            final String error
    ){
        final var uuid = UUID.randomUUID();
        final var dateNow = LocalDateTime.now();
        return new LoggerErrorEntity(
                uuid,
                identifier,
                application,
                process,
                error,
                dateNow
        );
    }
}

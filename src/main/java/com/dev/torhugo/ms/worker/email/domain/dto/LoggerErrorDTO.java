package com.dev.torhugo.ms.worker.email.domain.dto;

public record LoggerErrorDTO(
        String identifier,
        String application,
        String process,
        String error
) {
}

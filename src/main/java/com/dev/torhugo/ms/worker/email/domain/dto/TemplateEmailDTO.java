package com.dev.torhugo.ms.worker.email.domain.dto;

import lombok.Builder;

@Builder
public record TemplateEmailDTO(
        String subject,
        String text
) {
}

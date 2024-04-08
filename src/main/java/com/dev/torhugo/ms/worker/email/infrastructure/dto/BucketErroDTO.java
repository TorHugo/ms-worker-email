package com.dev.torhugo.ms.worker.email.infrastructure.dto;

public record BucketErroDTO(
        String identifier,
        String process,
        String error
) {
}

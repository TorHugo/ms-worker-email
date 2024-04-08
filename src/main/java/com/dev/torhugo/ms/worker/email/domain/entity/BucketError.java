package com.dev.torhugo.ms.worker.email.domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class BucketError {
    private final UUID bucketId;
    private final String process;
    private final String application;
    private final String identifier;
    private final String error;
    private final LocalDateTime createdAt;

    private BucketError(final UUID bucketId,
                        final String process,
                        final String application,
                        final String identifier,
                        final String error,
                        final LocalDateTime createdAt) {
        this.bucketId = bucketId;
        this.process = process;
        this.application = application;
        this.identifier = identifier;
        this.error = error;
        this.createdAt = createdAt;
    }

    public static BucketError create(final String process,
                                     final String error,
                                     final String identifier){
        final var uuid = UUID.randomUUID();
        final var applicationOfName = "queue-worker-mail";
        final var dateNow = LocalDateTime.now();
        return new BucketError(
                uuid,
                process,
                applicationOfName,
                identifier,
                error,
                dateNow
        );
    }
}

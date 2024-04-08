package com.dev.torhugo.ms.worker.email.application.repository;

import com.dev.torhugo.ms.worker.email.domain.entity.BucketError;

public interface BucketRepository {
    void save(final BucketError bucket);
}

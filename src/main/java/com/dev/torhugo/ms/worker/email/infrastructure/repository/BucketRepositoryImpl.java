package com.dev.torhugo.ms.worker.email.infrastructure.repository;

import com.dev.torhugo.ms.worker.email.application.repository.BucketRepository;
import com.dev.torhugo.ms.worker.email.domain.entity.BucketError;
import com.dev.torhugo.ms.worker.email.infrastructure.repository.database.BucketJpaRepository;
import com.dev.torhugo.ms.worker.email.infrastructure.repository.entity.BucketEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BucketRepositoryImpl implements BucketRepository {
    private final BucketJpaRepository bucketJpaRepository;

    @Override
    public void save(final BucketError bucket) {
        bucketJpaRepository.save(BucketEntity.fromAggregate(bucket));
    }
}

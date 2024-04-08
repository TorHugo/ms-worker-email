package com.dev.torhugo.ms.worker.email.infrastructure.repository.database;

import com.dev.torhugo.ms.worker.email.infrastructure.repository.entity.BucketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BucketJpaRepository extends JpaRepository<BucketEntity, UUID> {
}

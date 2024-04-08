package com.dev.torhugo.ms.worker.email.repository;

import com.dev.torhugo.ms.worker.email.domain.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateRepository extends JpaRepository<TemplateEntity, UUID> {
    TemplateEntity findByQueueAndActiveTrue(final String queue);

}

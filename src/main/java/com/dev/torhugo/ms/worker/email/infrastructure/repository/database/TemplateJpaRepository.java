package com.dev.torhugo.ms.worker.email.infrastructure.repository.database;

import com.dev.torhugo.ms.worker.email.infrastructure.repository.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateJpaRepository extends JpaRepository<TemplateEntity, UUID> {
    TemplateEntity findByProcessIgnoreCaseAndActiveTrue(final String process);

}

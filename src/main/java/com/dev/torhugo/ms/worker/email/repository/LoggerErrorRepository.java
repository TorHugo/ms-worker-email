package com.dev.torhugo.ms.worker.email.repository;

import com.dev.torhugo.ms.worker.email.domain.entity.LoggerErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoggerErrorRepository extends JpaRepository<LoggerErrorEntity, UUID> {
}

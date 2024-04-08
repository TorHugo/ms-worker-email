package com.dev.torhugo.ms.worker.email.infrastructure.repository;

import com.dev.torhugo.ms.worker.email.application.repository.TemplateRepository;
import com.dev.torhugo.ms.worker.email.domain.entity.TemplateMail;
import com.dev.torhugo.ms.worker.email.infrastructure.repository.database.TemplateJpaRepository;
import com.dev.torhugo.ms.worker.email.infrastructure.repository.entity.TemplateEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TemplateRepositoryImpl implements TemplateRepository {
    private final TemplateJpaRepository templateJpaRepository;
    @Override
    public TemplateMail findTemplateByProcessAndActive(final String process) {
        log.info("Executing findTemplateByProcessAndActive({}).", process);
        final var template = templateJpaRepository.findByProcessIgnoreCaseAndActiveTrue(process);
        return TemplateEntity.toAggregate(template);
    }
}

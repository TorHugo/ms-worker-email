package com.dev.torhugo.ms.worker.email.service.impl;

import com.dev.torhugo.ms.worker.email.domain.dto.TemplateEmailDTO;
import com.dev.torhugo.ms.worker.email.domain.exception.InvalidArgumentException;
import com.dev.torhugo.ms.worker.email.domain.exception.RepositoryException;
import com.dev.torhugo.ms.worker.email.repository.TemplateRepository;
import com.dev.torhugo.ms.worker.email.service.TemplateMailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateMailServiceImpl implements TemplateMailService {
    private final TemplateRepository templateRepository;
    @Override
    public TemplateEmailDTO getTemplate(final String queue) {
        final var template = templateRepository.findByQueueAndActiveTrue(queue);
        if (Objects.isNull(template))
            throw new RepositoryException("Template not found!");
        if (!template.isEmail())
            throw new InvalidArgumentException("This is not an email template!");
        return TemplateEmailDTO.builder()
                .subject(template.getSubject())
                .text(template.getTemplate())
                .build();
    }
}

package com.dev.torhugo.ms.worker.email.application.usecase;

import com.dev.torhugo.ms.worker.email.application.repository.TemplateRepository;
import com.dev.torhugo.ms.worker.email.domain.exception.InvalidArgumentException;
import com.dev.torhugo.ms.worker.email.domain.exception.RepositoryException;
import com.dev.torhugo.ms.worker.email.domain.vo.Message;

import java.util.Objects;
import java.util.logging.Logger;

public class FindTemplateUseCase {
    private final Logger log = Logger.getLogger(getClass().getName());
    private final TemplateRepository templateRepository;

    public FindTemplateUseCase(final TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Message execute(final String process){
        log.info("Executing usecase: FindTemplate().");
        final var template = templateRepository.findTemplateByProcessAndActive(process);
        if (Objects.isNull(template))
            throw new RepositoryException("Template not found!");
        if (!template.isEmail())
            throw new InvalidArgumentException("This is not an email template!");
        log.info("Template: " + template.getMessage());
        return template.getMessage();
    }
}

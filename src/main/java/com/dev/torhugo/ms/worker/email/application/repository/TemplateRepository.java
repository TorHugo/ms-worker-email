package com.dev.torhugo.ms.worker.email.application.repository;

import com.dev.torhugo.ms.worker.email.domain.entity.TemplateMail;

public interface TemplateRepository {
    TemplateMail findTemplateByProcessAndActive(final String process);
}

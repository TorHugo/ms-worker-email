package com.dev.torhugo.ms.worker.email.service;

import com.dev.torhugo.ms.worker.email.domain.dto.TemplateEmailDTO;

public interface TemplateMailService {
    TemplateEmailDTO getTemplate(final String queue);
}

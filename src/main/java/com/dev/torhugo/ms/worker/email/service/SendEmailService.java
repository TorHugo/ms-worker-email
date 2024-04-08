package com.dev.torhugo.ms.worker.email.service;

import com.dev.torhugo.ms.worker.email.domain.dto.TemplateEmailDTO;

public interface SendEmailService {
    void execute(final String emailTo,
                 final TemplateEmailDTO template);
}

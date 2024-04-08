package com.dev.torhugo.ms.worker.email.service;

import com.dev.torhugo.ms.worker.email.domain.dto.LoggerErrorDTO;

public interface LoggerErrorService {
    void save(final LoggerErrorDTO input);
}

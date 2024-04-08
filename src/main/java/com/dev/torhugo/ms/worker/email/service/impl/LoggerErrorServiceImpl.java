package com.dev.torhugo.ms.worker.email.service.impl;

import com.dev.torhugo.ms.worker.email.domain.dto.LoggerErrorDTO;
import com.dev.torhugo.ms.worker.email.domain.mappers.LoggerErrorMapper;
import com.dev.torhugo.ms.worker.email.repository.LoggerErrorRepository;
import com.dev.torhugo.ms.worker.email.service.LoggerErrorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoggerErrorServiceImpl implements LoggerErrorService {
    private final LoggerErrorRepository loggerErrorRepository;
    @Override
    public void save(final LoggerErrorDTO input) {
        log.info("Saving error.");
        loggerErrorRepository.save(LoggerErrorMapper.mappingToEntity(input));
    }
}

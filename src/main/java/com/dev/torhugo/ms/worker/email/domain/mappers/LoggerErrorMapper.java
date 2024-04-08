package com.dev.torhugo.ms.worker.email.domain.mappers;

import com.dev.torhugo.ms.worker.email.domain.dto.LoggerErrorDTO;
import com.dev.torhugo.ms.worker.email.domain.entity.LoggerErrorEntity;

public class LoggerErrorMapper {
    public static LoggerErrorEntity mappingToEntity(final LoggerErrorDTO input){
        return LoggerErrorEntity.create(
            input.identifier(),
            input.application(),
            input.process(),
            input.error()
        );
    }
}

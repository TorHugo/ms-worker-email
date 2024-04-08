package com.dev.torhugo.ms.worker.email.infrastructure.service;

import com.dev.torhugo.ms.worker.email.domain.exception.InvalidArgumentException;

public abstract class AbstractExecuteSendMail {
    public void execute(final Object object,
                        final String process){
        throw new InvalidArgumentException("Invalid arguments!");
    }
}

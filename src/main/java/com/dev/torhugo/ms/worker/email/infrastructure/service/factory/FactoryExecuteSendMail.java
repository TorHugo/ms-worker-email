package com.dev.torhugo.ms.worker.email.infrastructure.service.factory;

import com.dev.torhugo.ms.worker.email.domain.exception.InvalidArgumentException;
import com.dev.torhugo.ms.worker.email.infrastructure.service.AbstractExecuteSendMail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FactoryExecuteSendMail {
    private final WelcomeSendMail welcomeSendMail;
    private final ForgetPasswordSendMail forgetPasswordSendMail;

    public void getFactory(final String process,
                           final Object object){
        log.info("Factory SendMail. Process: {}", process);
        AbstractExecuteSendMail abstractExecuteSendMail =
                switch (process) {
                    case "welcome-to-email" -> welcomeSendMail;
                    case "forget-password-to-email" -> forgetPasswordSendMail;
                default -> throw new InvalidArgumentException("Invalid process! Process: " + process);
        };
        abstractExecuteSendMail.execute(object, process);
    }
}

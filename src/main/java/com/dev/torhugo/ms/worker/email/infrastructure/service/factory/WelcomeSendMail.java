package com.dev.torhugo.ms.worker.email.infrastructure.service.factory;

import com.dev.torhugo.ms.worker.email.application.usecase.FindTemplateUseCase;
import com.dev.torhugo.ms.worker.email.application.usecase.SaveBucketUseCase;
import com.dev.torhugo.ms.worker.email.application.usecase.SendEmailUseCase;
import com.dev.torhugo.ms.worker.email.infrastructure.dto.EmailDTO;
import com.dev.torhugo.ms.worker.email.infrastructure.service.AbstractExecuteSendMail;
import com.dev.torhugo.ms.worker.email.infrastructure.service.mappers.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WelcomeSendMail extends AbstractExecuteSendMail {
    public WelcomeSendMail(final FindTemplateUseCase findTemplateUseCase,
                           final SendEmailUseCase sendEmailUseCase,
                           final SaveBucketUseCase saveBucketUseCase,
                           final MessageMapper messageMapper) {
        super(findTemplateUseCase, sendEmailUseCase, saveBucketUseCase, messageMapper);
    }

    @Override
    protected String getObject(final Object object) {
        final var objectMessage = (EmailDTO) object;
        return objectMessage.emailTo();
    }
}

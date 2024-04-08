package com.dev.torhugo.ms.worker.email.infrastructure.service.factory;

import com.dev.torhugo.ms.worker.email.application.usecase.FindTemplateUseCase;
import com.dev.torhugo.ms.worker.email.application.usecase.SaveBucketUseCase;
import com.dev.torhugo.ms.worker.email.application.usecase.SendEmailUseCase;
import com.dev.torhugo.ms.worker.email.domain.vo.Message;
import com.dev.torhugo.ms.worker.email.infrastructure.dto.ForgetPasswordDTO;
import com.dev.torhugo.ms.worker.email.infrastructure.service.AbstractExecuteSendMail;
import com.dev.torhugo.ms.worker.email.infrastructure.service.mappers.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class ForgetPasswordSendMail extends AbstractExecuteSendMail {
    public ForgetPasswordSendMail(final FindTemplateUseCase findTemplateUseCase,
                                  final SendEmailUseCase sendEmailUseCase,
                                  final SaveBucketUseCase saveBucketUseCase,
                                  final MessageMapper messageMapper) {
        super(findTemplateUseCase, sendEmailUseCase, saveBucketUseCase, messageMapper);
    }

    @Override
    protected String getObject(final Object object) {
        final var objectMessage = (ForgetPasswordDTO) object;
        return objectMessage.emailTo();
    }

    @Override
    protected String getMessage(final Message template,
                                final Object object) {
        final var objectMessage = (ForgetPasswordDTO) object;
        final var expirationDate = LocalDateTime.parse(objectMessage.expirationDate());
        final var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        final var formattedExpirationDate = expirationDate.format(formatter);

        return template.introduction() + " " +
                template.body() + " " +
                objectMessage.hash() + " " +
                template.conclusion() + " " +
                formattedExpirationDate + " " +
                template.signature();
    }
}

package com.dev.torhugo.ms.worker.email.infrastructure.service.factory;

import com.dev.torhugo.ms.worker.email.application.usecase.FindTemplateUseCase;
import com.dev.torhugo.ms.worker.email.application.usecase.SaveBucketUseCase;
import com.dev.torhugo.ms.worker.email.application.usecase.SendEmailUseCase;
import com.dev.torhugo.ms.worker.email.infrastructure.dto.BucketErroDTO;
import com.dev.torhugo.ms.worker.email.infrastructure.dto.EmailDTO;
import com.dev.torhugo.ms.worker.email.infrastructure.service.AbstractExecuteSendMail;
import com.dev.torhugo.ms.worker.email.infrastructure.service.mappers.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WelcomeSendMail extends AbstractExecuteSendMail {
    private final FindTemplateUseCase findTemplateUseCase;
    private final SendEmailUseCase sendEmailUseCase;
    private final SaveBucketUseCase saveBucketUseCase;
    private final MessageMapper messageMapper;
    @Override
    public void execute(final Object object,
                        final String process) {
        final var input = (EmailDTO) object;
        final var templateEmail = findTemplateUseCase.execute(process);

        try {
            sendEmailUseCase.execute(messageMapper.buildMessage(
                    input.emailTo(),
                    templateEmail.subject(),
                    templateEmail.getMessage()
            ));
        } catch (final MailException mailException){
            log.error("Failed to send email! Error: {}.", mailException.getMessage());
            final var bucket = new BucketErroDTO(input.emailTo(), "send-email", mailException.getMessage());
            saveBucketUseCase.execute(bucket);
        } catch (final Exception exception){
            log.error("Failed to execute process! Error: {}.", exception.getMessage());
            final var bucket = new BucketErroDTO(input.emailTo(), "send-email", exception.getMessage());
            saveBucketUseCase.execute(bucket);
        }
    }
}

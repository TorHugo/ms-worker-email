package com.dev.torhugo.ms.worker.email.infrastructure.service;

import com.dev.torhugo.ms.worker.email.application.usecase.FindTemplateUseCase;
import com.dev.torhugo.ms.worker.email.application.usecase.SaveBucketUseCase;
import com.dev.torhugo.ms.worker.email.application.usecase.SendEmailUseCase;
import com.dev.torhugo.ms.worker.email.domain.exception.InvalidArgumentException;
import com.dev.torhugo.ms.worker.email.domain.vo.Message;
import com.dev.torhugo.ms.worker.email.infrastructure.dto.BucketErroDTO;
import com.dev.torhugo.ms.worker.email.infrastructure.service.mappers.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractExecuteSendMail {
    private final FindTemplateUseCase findTemplateUseCase;
    private final SendEmailUseCase sendEmailUseCase;
    private final SaveBucketUseCase saveBucketUseCase;
    private final MessageMapper messageMapper;
    public void execute(final Object object,
                        final String process){
        final var emailTo = getObject(object);
        final var templateEmail = getTemplate(process);

        try {
            sendEmail(toMessage(
                    emailTo,
                    templateEmail.subject(),
                    getMessage(templateEmail, object)
            ));
        } catch (final MailException mailException){
            log.error("Failed to send email! Error: {}.", mailException.getMessage());
            final var bucket = new BucketErroDTO(emailTo, "send-email", mailException.getMessage());
            saveBucket(bucket);
        } catch (final Exception exception){
            log.error("Failed to execute process! Error: {}.", exception.getMessage());
            final var bucket = new BucketErroDTO(emailTo, "send-email", exception.getMessage());
            saveBucket(bucket);
        }
    }

    protected String getObject(final Object object) {
        throw new InvalidArgumentException("Invalid arguments!");
    }

    protected Message getTemplate(final String process){
        return findTemplateUseCase.execute(process);
    }
    protected void sendEmail(final SimpleMailMessage message){
        sendEmailUseCase.execute(message);
    }

    protected void saveBucket(final BucketErroDTO bucket){
        saveBucketUseCase.execute(bucket);
    }
    protected String getMessage(final Message template,
                                final Object object){
        return template.getMessage();
    }
    protected SimpleMailMessage toMessage(final String emailTo,
                                          final String subject,
                                          final String text){
        return messageMapper.buildMessage(
                emailTo,
                subject,
                text
        );
    }
}

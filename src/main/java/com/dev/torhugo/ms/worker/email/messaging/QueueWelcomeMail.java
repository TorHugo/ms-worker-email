package com.dev.torhugo.ms.worker.email.messaging;

import com.dev.torhugo.ms.worker.email.domain.dto.EmailDTO;
import com.dev.torhugo.ms.worker.email.domain.dto.LoggerErrorDTO;
import com.dev.torhugo.ms.worker.email.service.LoggerErrorService;
import com.dev.torhugo.ms.worker.email.service.SendEmailService;
import com.dev.torhugo.ms.worker.email.service.TemplateMailService;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class QueueWelcomeMail {
    private final SendEmailService sendEmailService;
    private final TemplateMailService templateService;
    private final LoggerErrorService loggerErrorService;
    @RabbitListener(queues = "QUEUE_EMAIL_WELCOME")
    public synchronized void execute(final EmailDTO input,
                                     final Message message,
                                     final Channel channel) throws IOException {
        log.info("Executing QueueWelcomeMail. UserEmail: {}.", input.emailTo());
        try {
            final var template = templateService.getTemplate("QUEUE_EMAIL_WELCOME");
            sendEmailService.execute(input.emailTo(), template);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (final Exception error) {
            log.error("[Exception] Error: {}", error.getMessage());
            loggerErrorService.save(new LoggerErrorDTO(input.emailTo(), "ms-worker-email", "queue-receiver-message", error.getMessage()));
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }

    }
}

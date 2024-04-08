package com.dev.torhugo.ms.worker.email.infrastructure.adapter;

import com.dev.torhugo.ms.worker.email.infrastructure.dto.EmailDTO;
import com.dev.torhugo.ms.worker.email.infrastructure.dto.ForgetPasswordDTO;
import com.dev.torhugo.ms.worker.email.infrastructure.service.factory.FactoryExecuteSendMail;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
@Slf4j
public class QueueMessageForgetPasswordProcessPort {
    private static final String PROCESS_PORT = "forget-password-to-email";
    private final FactoryExecuteSendMail factoryExecuteSendMail;
    @RabbitListener(queues = "QUEUE_EMAIL_FORGET_PASSWORD")
    public synchronized void execute(final Message message,
                                     final Channel channel) throws IOException {
        log.info("Executing process: ForgetPassword().");
        try {
            final var messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
            final var input = new ObjectMapper().readValue(messageBody, ForgetPasswordDTO.class);
            factoryExecuteSendMail.getFactory(PROCESS_PORT, input);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (final Exception error) {
            log.error("[Exception] Error: {}", error.getMessage());
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }

    }
}

package com.dev.torhugo.ms.worker.email.infrastructure.adapter;

import com.dev.torhugo.ms.worker.email.infrastructure.dto.EmailDTO;
import com.dev.torhugo.ms.worker.email.infrastructure.service.factory.FactoryExecuteSendMail;
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
public class QueueMessageWelcomeProcessPort {
    private static final String PROCESS_PORT = "welcome-to-email";
    private final FactoryExecuteSendMail factoryExecuteSendMail;
    @RabbitListener(queues = "QUEUE_EMAIL_WELCOME")
    public synchronized void execute(final EmailDTO input,
                                     final Message message,
                                     final Channel channel) throws IOException {
        log.info("Executing process: WelcomeMail().");
        try {
            factoryExecuteSendMail.getFactory(PROCESS_PORT, input);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (final Exception error) {
            log.error("[Exception] Error: {}", error.getMessage());
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }

    }
}

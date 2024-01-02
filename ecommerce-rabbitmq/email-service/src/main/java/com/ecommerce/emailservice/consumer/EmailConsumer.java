package com.ecommerce.emailservice.consumer;

import com.ecommerce.emailservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {
    private final Logger LOGGER = LoggerFactory.getLogger(EmailConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consume(OrderEvent event) {
        LOGGER.info("Order event received in email service => %s".formatted(event.toString()));
        // email service needs to email customer
    }

}

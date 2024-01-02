package com.ecommerce.emailservice.kafka;

import com.ecommerce.basedomain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    private void consume(OrderEvent event) {
        LOGGER.info("Order event received in email service => %s".formatted(event.toString()));

    }
}

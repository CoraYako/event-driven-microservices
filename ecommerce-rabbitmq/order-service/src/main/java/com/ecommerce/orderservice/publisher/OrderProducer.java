package com.ecommerce.orderservice.publisher;

import com.ecommerce.orderservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.binding.routing.key}")
    private String orderRoutingKey;
    @Value("${rabbitmq.binding.email.routing.key}")
    private String emailRoutingKey;
    private final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent event) {
        LOGGER.info("Order event sent to RabbitMQ => %s".formatted(event.toString()));
        // send an order event to order queue
        rabbitTemplate.convertAndSend(exchange, orderRoutingKey, event);
        // send an order event to email queue
        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, event);
    }
}

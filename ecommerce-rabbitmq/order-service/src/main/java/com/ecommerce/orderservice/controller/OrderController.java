package com.ecommerce.orderservice.controller;

import com.ecommerce.orderservice.dto.Order;
import com.ecommerce.orderservice.dto.OrderEvent;
import com.ecommerce.orderservice.publisher.OrderProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public ResponseEntity<Object> placeOrder(@RequestBody Order order) {
        OrderEvent event = OrderEvent.builder()
                .status("PENDING")
                .message("order status is in pending state")
                .order(order)
                .build();
        orderProducer.sendMessage(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }
}

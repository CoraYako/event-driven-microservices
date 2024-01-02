package com.ecommerce.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Objects;

@Configuration
public class KafkaTpicConfig {
    private final Environment environment;

    public KafkaTpicConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public NewTopic topic() {
        String property = environment.getProperty("spring.kafka.topic.name");
        return TopicBuilder
                .name(Objects.requireNonNull(property))
                .build();
    }
}

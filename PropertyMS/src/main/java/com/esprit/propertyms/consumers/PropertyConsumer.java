package com.esprit.propertyms.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PropertyConsumer {
    @KafkaListener(topics = "topic-agent", groupId = "property-group")
    public void listen(String message) {
        System.out.println("Received: " + message);
    }
}

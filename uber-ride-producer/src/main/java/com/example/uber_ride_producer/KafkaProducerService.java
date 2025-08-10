package com.example.uber_ride_producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${kafka.topic}")
    private String topic;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRideMessage(Ride ride) {
        try {
            String message = objectMapper.writeValueAsString(ride);
            kafkaTemplate.send(topic, message);
            System.out.println("Sent message: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.uber_ride_consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {

    private final RideRepository rideRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaConsumerService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "uber_ride_group")
    public void consume(String message) {
        try {
            RideEntity ride = objectMapper.readValue(message, RideEntity.class);
            String operation = objectMapper.readTree(message).get("operation").asText();

            switch (operation) {
                case "CREATE":
                case "UPDATE":
                    rideRepository.save(ride);
                    break;
                case "DELETE":
                    rideRepository.deleteById(ride.getId());
                    break;
                default:
                    System.out.println("Unknown operation: " + operation);
            }

            System.out.println("Processed: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

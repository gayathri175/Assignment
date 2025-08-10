package com.example.uber_ride_producer;
import com.example.uber_ride_producer.Ride;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final KafkaProducerService kafkaProducerService;

    public RideController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public String createRide(@RequestBody Ride ride) {
        ride.setOperation("CREATE");
        kafkaProducerService.sendRideMessage(ride);
        return "Ride creation request sent to Kafka";
    }

    @PutMapping("/{id}")
    public String updateRide(@PathVariable Long id, @RequestBody Ride ride) {
        ride.setId(id);
        ride.setOperation("UPDATE");
        kafkaProducerService.sendRideMessage(ride);
        return "Ride update request sent to Kafka";
    }

    @DeleteMapping("/{id}")
    public String deleteRide(@PathVariable Long id) {
        Ride ride = new Ride();
        ride.setId(id);
        ride.setOperation("DELETE");
        kafkaProducerService.sendRideMessage(ride);
        return "Ride delete request sent to Kafka";
    }

    @GetMapping("/{id}")
    public String getRide(@PathVariable Long id) {
        Ride ride = new Ride();
        ride.setId(id);
        ride.setOperation("GET");
        kafkaProducerService.sendRideMessage(ride);
        return "Ride get request sent to Kafka (mock)";
    }
}

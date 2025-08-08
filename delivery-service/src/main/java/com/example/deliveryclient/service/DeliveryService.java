package com.example.deliveryclient.service;




import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DeliveryService {

    private final WebClient webClient;

    public DeliveryService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8081").build();
    }

    @CircuitBreaker(name = "deliveryService", fallbackMethod = "fallbackForDelivery")
    public String getDeliveryStatus() {
        return webClient.get()
                .uri("/delivery/status")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    // Fallback method (must match return type and arguments)
    public String fallbackForDelivery(Throwable t) {
        return "Delivery status service is currently unavailable. Please try again later.";
    }
}
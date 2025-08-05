package com.mycompany.restaurantapi;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Food {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Food name is required")
  private String name;

  @NotNull(message = "Price must be provided")
  private Double price;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;
}

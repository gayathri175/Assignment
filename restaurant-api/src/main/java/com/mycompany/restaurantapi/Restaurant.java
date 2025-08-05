package com.mycompany.restaurantapi;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Restaurant {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is required")
  private String name;

  @NotBlank(message = "Location is required")
  private String location;

  @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Food> foods = new ArrayList<>();
}

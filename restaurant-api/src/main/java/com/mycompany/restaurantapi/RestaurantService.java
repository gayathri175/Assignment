package com.mycompany.restaurantapi;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class RestaurantService {

  @Autowired
  private RestaurantRepository repo;

  public Restaurant create(Restaurant r) {
    r.getFoods().forEach(f -> f.setRestaurant(r));
    return repo.save(r);
  }

  public List<Restaurant> findAll() {
    return repo.findAll();
  }

  public Restaurant findById(Long id) {
    return repo.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found: " + id));
  }

  public void delete(Long id) {
    repo.delete(findById(id));
  }

  public Food addFood(Long rid, Food f) {
    Restaurant r = findById(rid);
    f.setRestaurant(r);
    r.getFoods().add(f);
    repo.save(r);
    return f;
  }
}

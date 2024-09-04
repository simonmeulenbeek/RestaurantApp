package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DishService {
    DishRepository repository;

    @Autowired
    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Dish getDishById(UUID id) {
        return repository.findById(id).orElse(null);
    }
}

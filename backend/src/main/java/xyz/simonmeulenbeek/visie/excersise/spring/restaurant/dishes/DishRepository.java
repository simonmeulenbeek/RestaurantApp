package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, UUID> {
    Dish save (Dish dish);
    Optional<Dish> findById(UUID id);
}
package xyz.simonmeulenbeek.visie.excersise.spring.restaurant;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish save (Dish dish);
    Optional<Dish> findById(long id);
}
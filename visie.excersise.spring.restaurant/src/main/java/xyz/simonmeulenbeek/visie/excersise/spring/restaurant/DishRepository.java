package xyz.simonmeulenbeek.visie.excersise.spring.restaurant;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface DishRepository extends ListCrudRepository<Dish, Long> {
    Dish save (Dish dish);
    Optional<Dish> findById(long id);
}
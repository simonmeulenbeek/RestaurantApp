package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
public class DishController {

    public final DishRepository repository;

    @Autowired
    public DishController(DishRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin
    @GetMapping
    public List<Dish> getAllDishes() {
        return repository.findAll();
    }
}
    
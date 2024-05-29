package xyz.simonmeulenbeek.visie.excersise.spring.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.model.Dish;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.DishRepository;

@RestController
@RequestMapping("/dishes")
public class DishController {

    public final DishRepository repository;

    @Autowired
    public DishController(DishRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Dish> getAllDishes() {
        return repository.findAll();
    }

}

package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.model;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.DishRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@SpringBootTest
@EntityScan(basePackages = "xyz.simonmeulenbeek.visie.excersise.spring.restaurant.model")
class DishTest {

    @Autowired
    private static DishRepository repository;

    @BeforeClass
    public static void setup() {
        Dish dish1 = new Dish(1, "aardappels", 2.57);
        Dish dish2 = new Dish(2, "patat", 4.57);
        Dish dish3 = new Dish(3, "frikandel", 2.50);
        Dish dish4 = new Dish(4, "kroket", 2.75);

        repository.save(dish1);
        repository.save(dish2);
        repository.save(dish3);
        repository.save(dish4);
    }

    @Test
    void canFetchItems() {
        List<Dish> list = repository.findAll();
        assertEquals("Found more/less than ", 4, list.size());
    }

    @Test
    void idMustBeUnique() {
        Dish testDish = new Dish(10, "friet", 4.50);
        assertThrows(Exception.class,
                () -> repository.save(testDish));
    }

}


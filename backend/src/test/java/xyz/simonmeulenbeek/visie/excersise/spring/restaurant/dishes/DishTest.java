package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes;

import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes.Dish;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes.DishRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DishTest {

    @Autowired
    private DishRepository repository;

    @BeforeAll
    void createTestData() {
        Dish dish;
        dish = new Dish("aardappels", 2.57);
        repository.save(dish);

        dish = new Dish("patat", 4.57);
        repository.save(dish);

        dish = new Dish("frikandel", 2.50);
        repository.save(dish);

        dish = new Dish("kroket", 2.75);
        repository.save(dish);
    }

    @Test
    void canFetchItems() {
        List<Dish> list = repository.findAll();
        Assertions.assertEquals(4, list.size(), "More items than added for tests");
    }
}


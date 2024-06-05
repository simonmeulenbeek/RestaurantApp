package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.model;

import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.DishRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DishTest {

    @Autowired
    private DishRepository repository;

    @BeforeAll
    void createTestData() {
        Dish dish;
        dish = new Dish(1, "aardappels", 2.57);
        repository.save(dish);

        dish = new Dish(2, "patat", 4.57);
        repository.save(dish);

        dish = new Dish(3, "frikandel", 2.50);
        repository.save(dish);

        dish = new Dish(4, "kroket", 2.75);
        repository.save(dish);
    }

    @Test
    void canFetchItems() {
        List<Dish> list = repository.findAll();
        Assertions.assertEquals(4, list.size(), "More items than added for tests");
    }

    @Test
    void idMustBeUnique() {
        Dish dish_before = repository.findById(1).get();
        Assumptions.assumeTrue("aardappels".equals(dish_before.name));

        Dish testDish = new Dish(1, "friet", 4.50);
        Assertions.assertThrows(Exception.class, () -> repository.save(testDish), "Should throw because ID already exists");

        Dish dish_after = repository.findById(1).get();
        Assertions.assertNotEquals(testDish, dish_after, "testItem shouldn't have been saved, but was returned from repository.");
    }

}


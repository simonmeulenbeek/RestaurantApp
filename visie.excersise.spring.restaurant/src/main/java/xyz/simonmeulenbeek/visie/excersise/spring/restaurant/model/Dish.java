package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    long id;
    String name;
    double price;

    public Dish(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
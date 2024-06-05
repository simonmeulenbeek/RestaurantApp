package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "dishes")
public class Dish implements Persistable<Long> {
    @Id
    long id;
    String name;
    double price;

    public Dish() {}

    public Dish(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
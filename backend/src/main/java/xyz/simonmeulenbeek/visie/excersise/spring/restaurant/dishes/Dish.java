package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.domain.Persistable;

import java.util.UUID;

@Entity
@Table(name = "dishes")
public class Dish implements Persistable<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id", columnDefinition = "CHAR(36)", insertable = false, updatable = false, nullable = false)
    UUID id;
    String name;
    double price;

    public Dish() {}

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return true;
    }
}
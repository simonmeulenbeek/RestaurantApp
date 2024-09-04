package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orderItems;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes.Dish;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders.Order;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id", columnDefinition = "CHAR(36)", insertable = false, updatable = false, nullable = false)
    UUID id;

    public OrderItem(Order order, Dish dish, int amount, double pricePerUnit) {
        this.order = order;
        this.dish = dish;
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
    }

    @ManyToOne(optional = false)
    Order order;
    @OneToOne(optional = false)
    Dish dish;

    int amount;
    double pricePerUnit;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
}

package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orderItems;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@IdClass(OrderItemPrimaryKey.class)
public class OrderItem {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    Order order;

    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "dish_id", nullable = false)
    Dish dish;

    public OrderItem() {}

    public OrderItem(Order order, Dish dish, int amount, double pricePerUnit) {
        this.order = order;
        this.dish = dish;
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
    }

    int amount;
    double pricePerUnit;

    @JsonManagedReference
    public Order getOrder() {
        return order;
    }

    @JsonManagedReference
    public Dish getDish() {
        return dish;
    }

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
}

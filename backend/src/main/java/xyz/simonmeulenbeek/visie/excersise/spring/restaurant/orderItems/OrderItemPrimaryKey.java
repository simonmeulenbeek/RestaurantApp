package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orderItems;

import java.io.Serializable;
import java.util.UUID;

public class OrderItemPrimaryKey implements Serializable {

    private UUID order;
    private UUID dish;

    public OrderItemPrimaryKey() {}

    public OrderItemPrimaryKey(UUID order, UUID dish) {
        this.order = order;
        this.dish = dish;
    }

    public UUID getOrder() {
        return order;
    }

    public void setOrder(UUID order) {
        this.order = order;
    }

    public UUID getDish() {
        return dish;
    }

    public void setDish(UUID dish) {
        this.dish = dish;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderItemPrimaryKey) {
            OrderItemPrimaryKey that = (OrderItemPrimaryKey) obj;

            return (that.order == this.order &&
                    that.dish == this.dish
            );
        }
        return false;
    }
}

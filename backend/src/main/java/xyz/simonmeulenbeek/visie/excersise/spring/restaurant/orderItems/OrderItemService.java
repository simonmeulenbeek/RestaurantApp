package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orderItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes.Dish;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders.Order;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService {
    OrderItemRepository repository;

    @Autowired
    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

    public OrderItem createForOrderDTO(Order order, Dish dish, OrderItemDTO orderItemDTO) {
        System.out.println("createForOrderDTO");
        System.out.println(order);
        System.out.println(dish);
        System.out.println(orderItemDTO);
        OrderItem item = new OrderItem(order, dish, orderItemDTO.amount, orderItemDTO.ppu);
        return repository.save(item);
    }

    public List<OrderItem> getAllOrderItems() {
        return repository.findAll();
    }

    public List<OrderItem> getOrderItemsByOrder(UUID id) {
        return repository.findByOrderId(id);
    }

}

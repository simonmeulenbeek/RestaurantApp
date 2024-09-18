package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions.CustomerSession;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions.CustomerSessionService;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes.Dish;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.dishes.DishService;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orderItems.OrderItemService;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    OrderRepository repository;
    OrderItemService orderItemService;
    CustomerSessionService customerSessionService;
    DishService dishService;

    @Autowired
    public OrderService(OrderRepository repository, OrderItemService orderItemService, CustomerSessionService customerSessionService, DishService dishService) {
        this.repository = repository;
        this.orderItemService = orderItemService;
        this.customerSessionService = customerSessionService;
        this.dishService = dishService;
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrderById(UUID orderId) {
        return repository.findById(orderId).orElse(null);
    }

    public List<Order> getOrdersForCustomerSession(UUID sessionId) {
        return repository.findByCustomerSessionId(sessionId);
    }

    public Order createNewOrder(NewOrderDTO request) {
        CustomerSession session = customerSessionService.getSessionById(UUID.fromString(request.sessionId));
        if (session == null) {
            return null;
        }
        Order newOrder = new Order(session);
        repository.save(newOrder);

        request.orderItems.forEach(orderItemDTO -> {
            Dish dishItem = dishService.getDishById(UUID.fromString(orderItemDTO.dishId));
            System.out.println("dish: " + dishItem.toString());
            orderItemService.createForOrderDTO(newOrder, dishItem, orderItemDTO);
        });
        
        return newOrder;
    }
}

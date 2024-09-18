package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderService service;

    @Autowired
    public OrderController(OrderService orderService) {
        this.service = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() { return service.getAllOrders(); }

    @GetMapping("/active")
    public List<Order> getAllActiveOrders() { return service.getAllOrders(); }

    @GetMapping("/{id}")
    public Order getSpecificOrder(@PathVariable UUID id) { return service.getOrderById(id); }

    @GetMapping("/session/{id}")
    public List<Order> getAllOrdersForSession(@PathVariable UUID id) { return service.getOrdersForCustomerSession(id); }

    @PostMapping("/new")
    public Order createOrder(@RequestBody NewOrderDTO newOrder) {
        return service.createNewOrder(newOrder);
    }
}

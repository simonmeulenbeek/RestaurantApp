package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {
    public final OrderRepository repository;

    @Autowired
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> getAllOrders() {return repository.findAll();}

    @GetMapping("/orders/{id}")
    public Optional<Order> getSpecificOrder(UUID id) {return repository.findById(id); }

    @PostMapping
    public Order createOrder(@RequestBody Order newOrder) {
        return repository.save(newOrder);
    }

    @PostMapping("/create")
    public Order createNewOrder() {return repository.save(new Order());}

}

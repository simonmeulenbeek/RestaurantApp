package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class CustomerSessionController {
    public final CustomerSessionRepository repository;

    @Autowired
    public CustomerSessionController(CustomerSessionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CustomerSession> getAllSessions() {
        return repository.findAll();
    }

    @PostMapping("/new")
    public CustomerSession createNewSession() {
        return repository.save(new CustomerSession());
    }
}

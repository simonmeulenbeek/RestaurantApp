package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.common.TabletAndTableDTO;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sessions")
public class CustomerSessionController {
    public final CustomerSessionService service;

    @Autowired
    public CustomerSessionController(CustomerSessionService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerSession> getAllSessions() { return service.getAllSessions(); }

    @PostMapping("/new")
    public CustomerSession createNewOrFetchExistingSession(@RequestBody TabletAndTableDTO request) {
        return service.createNewOrFetchExistingSession(UUID.fromString(request.getTableId()), UUID.fromString(request.getTabletId()));
    }

    @GetMapping("/table/{tableId}")
    public CustomerSession getForTable(@PathVariable String tableId) {
        return service.getExistingForTable(UUID.fromString(tableId));
    }
}

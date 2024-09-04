package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableData;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableDataService;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations.TabletRegistration;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets.TabletService;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets.Tablet;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerSessionService {
    CustomerSessionRepository repository;
    TableDataService tableService;
    TabletService tabletService;

    @Autowired
    public CustomerSessionService(CustomerSessionRepository customerSessionRepository, TableDataService tableService, TabletService tabletService) {
        this.repository = customerSessionRepository;
        this.tableService = tableService;
        this.tabletService = tabletService;
    }

    public List<CustomerSession> getAllSessions() {
        return repository.findAll();
    }

    public CustomerSession getSessionById(UUID sessionId) {
        return repository.findById(sessionId).orElse(null);
    }

    public CustomerSession createNewSession(UUID tableId, UUID tabletId) {
        TableData table = tableService.getTableData(tableId).get();
        Tablet tablet = tabletService.getTablet(tabletId).get();

        if (table == null || tablet == null) { return null; }

        CustomerSession existing = getExistingForTable(tableId);
        if (existing != null) {
            return existing;
        }

        if(table.getRegisteredTablets()
                .stream()
                .anyMatch(
                        item -> item.getTablet().getId() == tabletId
                )) {
            CustomerSession session = new CustomerSession();
            session.setTableData(table);

            return repository.save(session);
        }

        return null;
    }

    public CustomerSession getExistingForTable(UUID tableId) {
        return repository.getExistingForTable(tableId);
    }
}

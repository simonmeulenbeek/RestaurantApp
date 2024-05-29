package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableData;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableDataRepository;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableDataService;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets.Tablet;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets.TabletRepository;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets.TabletService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TabletRegistrationService {
    TabletService tabletService;
    TabletRegistrationRepository tabletRegistrationRepository;
    TableDataService tableDataService;

    @Autowired
    public TabletRegistrationService(TabletService tabletService,  TabletRegistrationRepository tabletRegistrationRepository, TableDataService tableDataService) {
        this.tabletService = tabletService;
        this.tabletRegistrationRepository = tabletRegistrationRepository;
        this.tableDataService = tableDataService;
    }

    public TabletRegistration getRegistrationForTablet(String tabletId) {
        TabletRegistration result = tabletRegistrationRepository.findByTablet(UUID.fromString(tabletId));
        return result;
    }

    public List<TabletRegistration> getRegistrationsForTable(String tableId) {
        return tabletRegistrationRepository.findByTable(UUID.fromString(tableId));
    }

    public List<TabletRegistration> getAllTabletRegistrations() {
        return tabletRegistrationRepository.findAll();
    }

    public TabletRegistration registerTabletToTable(String tabletId, String tableId) {
        Tablet tablet = tabletService.getTablet(UUID.fromString(tabletId)).orElseThrow(() -> new NoSuchElementException("Tablet not found"));
        TableData table = tableDataService.getTableData(UUID.fromString(tableId)).orElseThrow(() -> new NoSuchElementException("Table not found"));

        TabletRegistration registration = new TabletRegistration(tablet, table);
        return tabletRegistrationRepository.save(registration);
    }
}

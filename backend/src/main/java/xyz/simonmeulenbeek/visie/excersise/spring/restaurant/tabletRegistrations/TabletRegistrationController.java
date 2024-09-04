package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.common.TabletAndTableDTO;

import java.util.List;

@RestController
@RequestMapping("/tablet_registrations")
public class TabletRegistrationController {
    TabletRegistrationService tabletRegistrationService;

    @Autowired
    public TabletRegistrationController(TabletRegistrationService tabletRegistrationService) {
        this.tabletRegistrationService = tabletRegistrationService;
    }

    @GetMapping
    public List<TabletRegistration> listTabletRegistrations() {
        return this.tabletRegistrationService.getAllTabletRegistrations();
    }

    @GetMapping("/tablet/{tabletId}")
    public TabletRegistration getForTablet(@PathVariable("tabletId") String tabletId) {
        return tabletRegistrationService.getRegistrationForTablet(tabletId);
    }

    @PostMapping("/new")
    public TabletRegistration registerToTable(@RequestBody TabletAndTableDTO request) {
        return tabletRegistrationService.registerTabletToTable(request.getTabletId(), request.getTableId());
    }
}

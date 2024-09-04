package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tablets")
public class TabletController {
    public final TabletService tabletService;

    @Autowired
    public TabletController(TabletService tabletService) {
        this.tabletService = tabletService;
    }

    @GetMapping
    public List<Tablet> getTablets() {
        return tabletService.getTabletList();
    }

    @GetMapping("/{tabletId}")
    public Tablet getTablet(@PathVariable("tabletId") String tabletId) {
        return tabletService.getTablet(UUID.fromString(tabletId)).orElse(null);
    }

    @PostMapping("/new")
    public Tablet addNewTablet(@RequestBody NewTabletDTO request) {
        return tabletService.createNewTablet(request);
    }
}

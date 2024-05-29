package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TabletService {
    TabletRepository repository;

    @Autowired
    public TabletService(TabletRepository repository) {
        this.repository = repository;
    }

    public List<Tablet> getTabletList() {return repository.findAll();}

    public Optional<Tablet> getTablet(UUID tabletId) { return repository.findById(tabletId); }

    public Tablet createNewTablet(NewTabletDTO dto) {
        return createNewTablet(UUID.fromString(dto.getTabletId()));
    }

    public Tablet createNewTablet(UUID tabletId) {
        Tablet tablet = new Tablet();
        tablet.id = tabletId;
        return repository.save(tablet);
    }
}

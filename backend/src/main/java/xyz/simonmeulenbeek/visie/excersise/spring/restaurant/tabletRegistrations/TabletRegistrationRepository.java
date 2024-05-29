package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TabletRegistrationRepository extends JpaRepository<TabletRegistration, TabletRegistrationPrimaryKey> {
    Optional<TabletRegistration> findById(TabletRegistrationPrimaryKey id);
    TabletRegistration save(TabletRegistration registration);

    @Query("SELECT r FROM TabletRegistration r WHERE r.tablet.id = ?1")
    TabletRegistration findByTablet(UUID id);

    @Query("SELECT r FROM TabletRegistration r WHERE r.table.id = ?1")
    List<TabletRegistration> findByTable(UUID id);
}

package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations.TabletRegistration;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerSessionRepository extends JpaRepository<CustomerSession, UUID> {
    CustomerSession save(CustomerSession customerSession);
    List<CustomerSession> findAll();

    @Query("SELECT s FROM CustomerSession s WHERE s.tableData.id = ?1 ORDER BY s.updatedAt DESC LIMIT 1")
    CustomerSession getExistingForTable(UUID id);
}

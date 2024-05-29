package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerSessionRepository extends JpaRepository<CustomerSession, UUID> {
    CustomerSession save(CustomerSession customerSession);
    List<CustomerSession> findAll();
}

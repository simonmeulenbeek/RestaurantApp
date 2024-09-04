package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    Order save(Order order);
    List<Order> findAll();

    @Query("SELECT o FROM Order o WHERE o.session.id = ?1")
    List<Order> findByCustomerSessionId(UUID customerSessionId);

}

package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orderItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
    Optional<OrderItem> findById(UUID id);
    OrderItem save(OrderItem orderItem);

    @Query("SELECT oi FROM OrderItem oi WHERE oi.order.id = ?1")
    List<OrderItem> findByOrderId(UUID id);
}

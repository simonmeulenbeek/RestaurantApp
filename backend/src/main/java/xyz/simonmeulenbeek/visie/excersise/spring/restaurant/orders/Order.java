package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions.CustomerSession;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orderItems.OrderItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id", columnDefinition = "CHAR(36)", insertable = false, updatable = false, nullable = false)
    UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id")
    @JsonBackReference
    CustomerSession session;

    @OneToMany(mappedBy = "order")
    List<OrderItem> orderedItems;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    public Order() {}

    public Order(CustomerSession session) {
        this.session = session;
    }

    public UUID getId() {
        return this.id;
    }

    public CustomerSession getSession() { return this.session; }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
}

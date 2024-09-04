package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.customerSessions;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.orders.Order;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer_sessions")
public class CustomerSession {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id", columnDefinition = "CHAR(36)", insertable = false, updatable = false, nullable = false)
    UUID id;

    //TODO: Session status? --- NEE WANT DAT WORDT BEPAALD AAN DE HAND VAN BESTAANDE BETALINGEN VOOR DEZE CUSTOMER SESSION

    @OneToOne
    @JoinColumn(name = "table_id")
    TableData tableData;

    @OneToMany(mappedBy = "session", fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Order> orders;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    public CustomerSession() {}

    public UUID getId() {
        return id;
    }

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }

    public List<Order> getOrders() { return orders; }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

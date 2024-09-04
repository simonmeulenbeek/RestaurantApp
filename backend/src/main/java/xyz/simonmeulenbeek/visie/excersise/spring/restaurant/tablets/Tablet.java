package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations.TabletRegistration;

import java.sql.SQLType;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tablets")
public class Tablet {
    @Id
    @Column(name = "id", columnDefinition = "CHAR(36)", insertable = false, updatable = false, nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    UUID id;

    @OneToOne(mappedBy = "tablet")
    @PrimaryKeyJoinColumn
    TabletRegistration tabletRegistration;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    @JsonBackReference
    public TabletRegistration getTabletRegistration() {
        return tabletRegistration;
    }

    public void setTabletRegistration(TabletRegistration tabletRegistration) {
        this.tabletRegistration = tabletRegistration;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

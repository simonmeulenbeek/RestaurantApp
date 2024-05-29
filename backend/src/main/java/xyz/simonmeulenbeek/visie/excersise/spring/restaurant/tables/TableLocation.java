package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "table_locations")
public class TableLocation {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "table_id", columnDefinition = "CHAR(36)", insertable = false, updatable = false, nullable = false)
    UUID id;

    @OneToOne
    @JoinColumn(name = "table_id")
    TableData tableData;

    @Column(name = "x_pos") Integer xPosition;
    @Column(name = "y_pos") Integer yPosition;

    @Column(name = "x_size") Integer xSize;
    @Column(name = "y_size") Integer ySize;


    public UUID getId() {
        return id;
    }

    public TableData getTableData() {
        return tableData;
    }

    public Integer getXPosition() {
        return xPosition;
    }
    public Integer getYPosition() {
        return yPosition;
    }
    public Integer getXSize() {
        return xSize;
    }
    public Integer getYSize() { return ySize;}
}

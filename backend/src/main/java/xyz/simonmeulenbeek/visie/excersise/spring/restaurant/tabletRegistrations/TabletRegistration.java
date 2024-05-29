package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations;

import jakarta.persistence.*;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableData;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets.Tablet;

import java.util.UUID;

@Entity
@Table(name = "tablet_registrations")
@IdClass(TabletRegistrationPrimaryKey.class)
public class TabletRegistration {

    @Id
    @OneToOne
    @JoinColumn(name = "tablet_id", nullable = false, unique = true)
    private Tablet tablet;

    @Id
    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private TableData table;

    public TabletRegistration() {}

    public TabletRegistration(Tablet tablet, TableData tableData) {
        this.tablet = tablet;
        this.table = tableData;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public void setTablet(Tablet tablet) {
        this.tablet = tablet;
    }

    public TableData getTableData() {
        return table;
    }

    public void setTableData(TableData tableData) {
        this.table = tableData;
    }
}


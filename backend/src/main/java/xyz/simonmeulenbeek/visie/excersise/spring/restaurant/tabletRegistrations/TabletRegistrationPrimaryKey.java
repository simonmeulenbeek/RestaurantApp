package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;

import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables.TableData;
import xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets.Tablet;

public class TabletRegistrationPrimaryKey implements Serializable{

    private UUID tablet;
    private UUID table;

    public TabletRegistrationPrimaryKey() {}

    public TabletRegistrationPrimaryKey(UUID tablet, UUID table) {
        this.tablet = tablet;
        this.table = table;
    }

    public UUID getTablet() {
        return tablet;
    }

    public void setTablet(UUID tablet) {
        this.tablet = tablet;
    }

    public UUID getTable() {
        return table;
    }

    public void setTable(UUID table) {
        this.table = table;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TabletRegistrationPrimaryKey) {
            TabletRegistrationPrimaryKey that = (TabletRegistrationPrimaryKey) obj;

            return (
                    that.table == this.table &&
                    that.tablet == this.tablet
            );
        }
        return false;
    }
}

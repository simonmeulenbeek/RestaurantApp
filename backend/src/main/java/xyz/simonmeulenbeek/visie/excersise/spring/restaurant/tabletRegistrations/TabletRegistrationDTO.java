package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tabletRegistrations;

public class TabletRegistrationDTO {
    private String tabletId;
    private String tableId;

    public String getTabletId() {
        return tabletId;
    }

    public void setTabletId(String tabletId) {
        this.tabletId = tabletId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}

package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TableDataService {
    TableDataRepository repository;

    @Autowired
    public TableDataService(TableDataRepository repository) {
        this.repository = repository;
    }

    public List<TableData> getFreeTables() {
        return null;
    }

    public List<TableData> getTableDataList() {
        return repository.findAll();
    }

    public Optional<TableData> getTableData(UUID tableId) {
        return repository.findById(tableId);
    }

    public TableData addTable() {
        return repository.save(new TableData());
    }

    public TableData updateTable(TableData data) {
        return repository.save(data);
    }
}

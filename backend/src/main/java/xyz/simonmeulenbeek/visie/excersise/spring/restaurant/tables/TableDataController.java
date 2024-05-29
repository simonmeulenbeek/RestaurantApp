package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tables")
public class TableDataController {
    public final TableDataService service;

    @Autowired
    public TableDataController(TableDataService service) {
        this.service = service;
    }

    @GetMapping
    public List<TableData> getAllTableData() {
        return service.getTableDataList();
    }

    @GetMapping("/{tableId}")
    public TableData getTableData(@PathVariable("tableId") String tableId) {
        return service.getTableData(UUID.fromString(tableId)).orElse(null);
    }
}

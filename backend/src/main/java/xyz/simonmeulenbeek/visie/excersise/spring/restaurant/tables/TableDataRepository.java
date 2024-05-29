package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TableDataRepository extends JpaRepository<TableData, UUID> {
    TableData save(TableData tableData);
    Optional<TableData> findById(UUID id);
}

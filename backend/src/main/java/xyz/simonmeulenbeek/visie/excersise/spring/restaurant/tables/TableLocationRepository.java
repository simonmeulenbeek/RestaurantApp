package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableLocationRepository extends JpaRepository<TableLocation, TableData> {
    TableLocation save(TableLocation tableLocation);
    Optional<TableLocation> findByTableData(TableData table);
}

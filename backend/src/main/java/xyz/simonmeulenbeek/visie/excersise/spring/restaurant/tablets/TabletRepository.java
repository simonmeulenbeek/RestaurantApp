package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.tablets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TabletRepository extends JpaRepository<Tablet, UUID> {
    Optional<Tablet> findById(UUID id);
    Tablet save(Tablet Tablet);
}

package pl.zone.ZoneBackendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zone.ZoneBackendApp.entity.QuantityType;

@Repository
public interface QuantityTypeRepository extends JpaRepository<QuantityType, Long> {

}

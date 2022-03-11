package pl.zone.ZoneBackendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zone.ZoneBackendApp.entity.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

}

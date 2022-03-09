package pl.zone.ZoneBackendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zone.ZoneBackendApp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}

package pl.zone.ZoneBackendApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.zone.ZoneBackendApp.dto.EmployeeDto;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    private String firstName;

    private String lastName;

    private String salary;

    @OneToOne(mappedBy = "employee")
    private Operator operator;

    public static Employee of(EmployeeDto dto) {
        Employee employee = new Employee();

        employee.setIdEmployee(dto.getIdEmployee());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setSalary(dto.getSalary());

        return employee;
    }
}

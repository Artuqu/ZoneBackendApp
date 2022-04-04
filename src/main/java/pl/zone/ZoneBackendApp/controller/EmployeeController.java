package pl.zone.ZoneBackendApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zone.ZoneBackendApp.dto.EmployeeDto;
import pl.zone.ZoneBackendApp.entity.Employee;
import pl.zone.ZoneBackendApp.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeRepository er;

    @PostMapping("/employees")
    public EmployeeDto saveOrUpdateEmployeeDto(EmployeeDto employeeDto) {
        if (employeeDto.getIdEmployee() == null) {
            return EmployeeDto.of(er.save(Employee.of(employeeDto)));
        } else {
            Optional<Employee> byId = er.findById(employeeDto.getIdEmployee());
            if (byId.isPresent()) {
                Employee updateEmployee = byId.get();
                updateEmployee.setFirstName(employeeDto.getFirstName());
                updateEmployee.setLastName(employeeDto.getLastName());
                updateEmployee.setSalary(employeeDto.getSalary());
                return EmployeeDto.of(er.save(updateEmployee));
            } else throw new RuntimeException("Can't find user with id " + employeeDto.getIdEmployee());
        }
    }

    @GetMapping("/employees/{idEmployee}")
    public EmployeeDto getEmployee(@PathVariable Long idEmployee) throws InterruptedException {
        Thread.sleep(500);
        return EmployeeDto.of(er.findById(idEmployee).get());
    }

//    @PutMapping("/employees/edit/{idEmployee}")
//    public EmployeeDto editEmployee(@PathVariable Long idEmployee, @RequestBody EmployeeDto employeeDto) {
//        EmployeeDto dto = EmployeeDto.of(er.findById(idEmployee).get());
//        dto.setFirstName(employeeDto.getFirstName());
//        dto.setLastName(employeeDto.getLastName());
//        dto.setSalary(employeeDto.getSalary());
//        return EmployeeDto.of(er.save(Employee.of(dto)));
//    }

    @GetMapping("/employees")
    public List<EmployeeDto> listEmployees() {
        return er.findAll()
                .stream().
                map(EmployeeDto::of)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/employees")
    public ResponseEntity deleteEmployee(@RequestBody Long idEmployee) {
        er.deleteById(idEmployee);
        return ResponseEntity.ok().build();
    }

}

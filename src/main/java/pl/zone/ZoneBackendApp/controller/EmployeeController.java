package pl.zone.ZoneBackendApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zone.ZoneBackendApp.entity.Employee;
import pl.zone.ZoneBackendApp.repository.EmployeeRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeRepository er;

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return er.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employee> listEmployees() {
        return er.findAll();
    }

    @DeleteMapping("/employees")
    ResponseEntity deleteEmployee(@RequestBody Long idEmployee) {
        er.deleteById(idEmployee);
        return ResponseEntity.ok().build();
    }

}

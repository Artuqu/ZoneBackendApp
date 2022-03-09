package pl.zone.ZoneBackendApp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.zone.ZoneBackendApp.entity.Employee;
import pl.zone.ZoneBackendApp.repository.EmployeeRepository;

@RequiredArgsConstructor
@Controller
public class EmployeeController {


    private final EmployeeRepository er;

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return er.save(newEmployee);
    }

}

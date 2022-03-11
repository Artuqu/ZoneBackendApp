package pl.zone.ZoneBackendApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zone.ZoneBackendApp.entity.Operator;
import pl.zone.ZoneBackendApp.repository.OperatorRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OperatorController {

    private final OperatorRepository or;

    @PostMapping("/operators")
    Operator newOperator(@RequestBody Operator newOperator) {
        return or.save(newOperator);
    }

    @GetMapping("/operators")
    List<Operator> listOperators() {
        return or.findAll();
    }

    @DeleteMapping("/operators")
    ResponseEntity deleteOperator(@RequestBody Long idOperator) {
        or.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }

}

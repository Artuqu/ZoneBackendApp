package pl.zone.ZoneBackendApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zone.ZoneBackendApp.entity.QuantityType;
import pl.zone.ZoneBackendApp.repository.QuantityTypeRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class QuantityTypeController {

    private final QuantityTypeRepository qtr;

    @PostMapping("/quantity")
    public QuantityType newQuantityType(@RequestBody QuantityType newQuantityType) {
        return qtr.save(newQuantityType);
    }

    @GetMapping("/quantity")
    public List<QuantityType> listQuantityTypes() {
        return qtr.findAll();
    }

    @DeleteMapping("/quantity")
    public ResponseEntity deleteQuantityType(@RequestBody Long idQuantityType) {
        qtr.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }

}

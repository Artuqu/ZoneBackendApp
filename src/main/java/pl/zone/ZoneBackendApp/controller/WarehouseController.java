package pl.zone.ZoneBackendApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zone.ZoneBackendApp.entity.Warehouse;
import pl.zone.ZoneBackendApp.repository.WarehouseRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WarehouseController {

    private final WarehouseRepository wr;

    @PostMapping("/warehouses")
    public Warehouse newWarehouse(@RequestBody Warehouse newWarehouse) {
        return wr.save(newWarehouse);
    }

    @GetMapping("/warehouses")
    public List<Warehouse> listWarehouses() {
        return wr.findAll();
    }

    @DeleteMapping("/warehouses")
    public ResponseEntity deleteWarehouse(@RequestBody Long idWarehouse) {
        wr.deleteById(idWarehouse);
        return ResponseEntity.ok().build();
    }

}

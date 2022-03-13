package pl.zone.ZoneBackendApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zone.ZoneBackendApp.entity.Item;
import pl.zone.ZoneBackendApp.repository.ItemRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemRepository ir;

    @PostMapping("/items")
    public Item newItem(@RequestBody Item newItem) {
        return ir.save(newItem);
    }

    @GetMapping("/items")
    public List<Item> listItems() {
        return ir.findAll();
    }

    @DeleteMapping("/items")
    public ResponseEntity deleteItem(@RequestBody Long idItem) {
        ir.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

}

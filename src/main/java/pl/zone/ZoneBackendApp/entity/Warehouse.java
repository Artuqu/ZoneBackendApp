package pl.zone.ZoneBackendApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWarehouse;

    private String name;

    @ManyToMany (mappedBy = "warehouses")
    private List<Item> items;

}

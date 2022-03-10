package pl.zone.ZoneBackendApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    private String name;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "idQuantityType")
    private QuantityType quantityType;

    @ManyToMany
    @JoinTable(
            name = "item_warehouse",
            joinColumns = @JoinColumn(name = "idItem"),
            inverseJoinColumns = @JoinColumn(name = "idWarehouse")
    )
    private List<Warehouse> warehouses;
}

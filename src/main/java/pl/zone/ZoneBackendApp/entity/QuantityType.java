package pl.zone.ZoneBackendApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class QuantityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuantityType;

    private String name;

    @OneToMany(mappedBy = "quantityType")
    private List<Item> items;
}

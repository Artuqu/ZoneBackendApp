package pl.zone.ZoneBackendApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperator;

    private String login;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmployee")
    private Employee employee;


}

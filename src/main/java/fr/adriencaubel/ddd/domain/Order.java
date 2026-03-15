package fr.adriencaubel.ddd.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Client et Order sont dans deux agrégats différents
     */
    private Long clientId;

    /**
     * Order est la racine de l'agregat donc on référence la ligne via sa référence
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    public List<OrderLine> orderLines = new ArrayList<>();

    public Order() {}
}

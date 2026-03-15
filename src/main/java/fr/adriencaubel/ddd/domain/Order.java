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
    @JoinColumn(name = "order_id", nullable = false)
    public List<OrderLine> orderLines = new ArrayList<>();

    public Order() {}

    public Order(Long clientId) {
        this.clientId = clientId;
    }

    public void addOrderLine(Long articleId, int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        OrderLine orderLine = new OrderLine();
        orderLine.setArticleId(articleId);
        orderLine.setQuantity(quantity);
        orderLines.add(orderLine);
    }
}

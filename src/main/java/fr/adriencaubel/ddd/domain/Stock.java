package fr.adriencaubel.ddd.domain;

import jakarta.persistence.*;

@Entity
@Table(
        name = "stock",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"article_id", "provider_id"}
        )
)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "article_id", nullable = false)
    private Long articleId;

    @Column(name = "provider_id", nullable = false)
    private Long providerId;

    @Column(nullable = false)
    private int quantity;

    @Version
    private long version;

    protected Stock() {
    }

    public Stock(Long articleId, Long providerId, int quantity) {
        this.articleId = articleId;
        this.providerId = providerId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reserve(int qty) {

        if (quantity < qty) {
            throw new IllegalStateException("Not enough stock");
        }

        quantity -= qty;
    }

    public void input(int qty) {
        quantity += qty;
    }
}

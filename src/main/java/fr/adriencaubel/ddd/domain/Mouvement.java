package fr.adriencaubel.ddd.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "mouvement")
@Getter
@Setter
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "article_id")
    private Long articleId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Enumerated(EnumType.STRING)
    private MouvementType type;

    private Integer quantity;

    private LocalDateTime date;

    public Mouvement() {}

    public Mouvement(Long articleId, MouvementType type, Integer quantity) {
        this.articleId = articleId;
        this.type = type;
        this.quantity = quantity;
    }
}

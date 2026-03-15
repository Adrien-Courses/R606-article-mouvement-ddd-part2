package fr.adriencaubel.ddd.domain.repository;

import fr.adriencaubel.ddd.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByArticleIdAndProviderId(
            Long articleId,
            Long providerId
    );
}

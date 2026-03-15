package fr.adriencaubel.ddd.application;

import fr.adriencaubel.ddd.domain.Stock;
import fr.adriencaubel.ddd.domain.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryUseCase {

    private final StockRepository stockRepository;

    public Stock stock(Long articleId, Long providerId) {
        return stockRepository.findByArticleIdAndProviderId(articleId, providerId).orElseThrow();
    }
}
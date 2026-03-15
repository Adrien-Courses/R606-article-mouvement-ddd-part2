package fr.adriencaubel.ddd.application;

import fr.adriencaubel.ddd.domain.Mouvement;
import fr.adriencaubel.ddd.domain.MouvementType;
import fr.adriencaubel.ddd.domain.Stock;
import fr.adriencaubel.ddd.domain.repository.MouvementRepository;
import fr.adriencaubel.ddd.domain.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final StockRepository stockRepository;

    private final MouvementRepository mouvementRepository;

    @Transactional
    public void create(Long articleId, Long providerId, int quantity) {
        Stock stock = stockRepository
                .findByArticleIdAndProviderId(articleId, providerId)
                .orElseThrow();

        stock.reserve(quantity);

        // Création d'une commande à base de donnée
        System.out.println("Création d'une commande à base de donnée");

        stockRepository.save(stock); // Si accès concurrent alors optimistic locking exception

        Mouvement mouvement = new Mouvement(articleId, MouvementType.OUTPUT, quantity);
        mouvementRepository.save(mouvement);
    }
}

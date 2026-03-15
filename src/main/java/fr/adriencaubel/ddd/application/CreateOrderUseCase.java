package fr.adriencaubel.ddd.application;

import fr.adriencaubel.ddd.domain.*;
import fr.adriencaubel.ddd.domain.repository.*;
import fr.adriencaubel.ddd.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final StockRepository stockRepository;

    private final MouvementRepository mouvementRepository;

    private final OrderDomainService orderDomainService;

    private final ArticleRepository articleRepository;

    private final ClientRepository clientRepository;

    private final OrderRepository orderRepository;

    private final ProviderRepository providerRepository;


    /**
     * Contient uniquement l'orchestration :
     * - récupère en base de données les entités
     * - persiste en base de données les entités + envoie de mail par exemple
     */
    @Transactional
    public void create(Long articleId, Long providerId, Long clientId, int quantity) {
        Stock stock = stockRepository
                .findByArticleIdAndProviderId(articleId, providerId)
                .orElseThrow();

        Provider provider = providerRepository.findById(providerId).orElseThrow();

        Article article = articleRepository.findById(articleId).orElseThrow();

        Client client = clientRepository.findById(clientId).orElseThrow();

        OrderResult orderResult = orderDomainService.createOrder(client, article, quantity, stock, provider);

        mouvementRepository.save(orderResult.mouvement);
        orderRepository.save(orderResult.order);
    }
}

package fr.adriencaubel.ddd.application;

import fr.adriencaubel.ddd.domain.repository.MouvementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MouvementUseCase {
    private final MouvementRepository mouvementRepository;

    public void create(Long articleId, Long providerId, int quantity) {
        // fait de la logique métier
    }

    public void delete(Long id) {
        // fait de la logique métier
    }
}

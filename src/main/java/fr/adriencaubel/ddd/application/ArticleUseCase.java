package fr.adriencaubel.ddd.application;

import fr.adriencaubel.ddd.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleUseCase {
    private final ArticleRepository articleRepository;

}

package fr.adriencaubel.ddd.domain.repository;

import fr.adriencaubel.ddd.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

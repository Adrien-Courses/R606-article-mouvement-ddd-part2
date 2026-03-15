package fr.adriencaubel.ddd.domain.repository;

import fr.adriencaubel.ddd.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}

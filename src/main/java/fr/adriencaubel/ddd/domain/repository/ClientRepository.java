package fr.adriencaubel.ddd.domain.repository;

import fr.adriencaubel.ddd.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

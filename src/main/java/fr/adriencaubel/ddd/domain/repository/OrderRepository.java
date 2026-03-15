package fr.adriencaubel.ddd.domain.repository;

import fr.adriencaubel.ddd.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

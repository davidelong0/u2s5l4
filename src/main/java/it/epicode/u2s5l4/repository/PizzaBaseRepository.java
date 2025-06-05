package it.epicode.u2s5l4.repository;

import it.epicode.u2s5l4.model.PizzaBase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PizzaBaseRepository extends JpaRepository<PizzaBase, Long> {
    Optional<PizzaBase> findByName(String name);
}

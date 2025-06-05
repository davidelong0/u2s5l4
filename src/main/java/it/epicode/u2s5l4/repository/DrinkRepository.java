package it.epicode.u2s5l4.repository;

import it.epicode.u2s5l4.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    // Esempio query custom (JPQL)
    List<Drink> findByPriceLessThan(double price);
}

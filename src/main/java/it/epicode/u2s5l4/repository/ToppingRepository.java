package it.epicode.u2s5l4.repository;

import it.epicode.u2s5l4.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
    Optional<Topping> findByName(String name);
}

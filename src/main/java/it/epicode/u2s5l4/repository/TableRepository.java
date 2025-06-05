package it.epicode.u2s5l4.repository;

import it.epicode.u2s5l4.model.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Tavolo, Long> {}

package it.epicode.u2s5l4.repository;

import it.epicode.u2s5l4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.statoOrdine = :stato")
    List<Order> findByStatoOrdine(@Param("stato") it.epicode.u2s5l4.enumeration.StatoOrdine stato);


}

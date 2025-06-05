// Order.java
package it.epicode.u2s5l4.model;

import it.epicode.u2s5l4.enumeration.StatoOrdine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroCoperti;
    private LocalTime oraAcquisizione;
    private boolean isAsporto;
    private double costoCoperto;
    private StatoOrdine statoOrdine;

    @ManyToMany
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> items = new ArrayList<>();

    @ManyToOne
    private Tavolo tavolo;

    public void addItem(ItemEntity item) {
        items.add(item);
    }

    public double getTotale() {
        double totaleItems = items.stream().mapToDouble(ItemEntity::getPrice).sum();
        return totaleItems + costoCoperto * numeroCoperti;
    }

    @Override
    public String toString() {
        return "Order ID: " + id + " | Tavolo: " + (tavolo != null ? tavolo.getNumero() : "N/D") +
                " | Totale: €" + getTotale() + " | Stato: " + statoOrdine;
    }
}

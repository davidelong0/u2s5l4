// Tavolo.java
package it.epicode.u2s5l4.model;

import it.epicode.u2s5l4.enumeration.StatoTavolo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tavolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private int maxCoperti;

    @Enumerated(EnumType.STRING)
    private StatoTavolo stato;
}

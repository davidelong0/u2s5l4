package it.epicode.u2s5l4.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PizzaBase extends ItemEntity {

    public PizzaBase(Long id, String name, double price, int calories) {
        super(id, name, price, calories);
    }

    @Override
    public String toString() {
        return getName() + " - €" + getPrice() + " - " + getCalories() + " kcal";
    }
}


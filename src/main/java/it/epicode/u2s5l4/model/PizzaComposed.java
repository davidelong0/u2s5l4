package it.epicode.u2s5l4.model;

import lombok.Getter;

import java.util.List;

@Getter
public class PizzaComposed implements Item {

    private final String name;
    private final PizzaBase base;
    private final List<Topping> toppings;

    public PizzaComposed(String name, PizzaBase base, List<Topping> toppings) {
        this.name = name;
        this.base = base;
        this.toppings = toppings;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double toppingsPrice = toppings.stream()
                .mapToDouble(Topping::getPrice)
                .sum();
        return base.getPrice() + toppingsPrice;
    }

    @Override
    public int getCalories() {
        int toppingsCalories = toppings.stream()
                .mapToInt(Topping::getCalories)
                .sum();
        return base.getCalories() + toppingsCalories;
    }

    @Override
    public String toString() {
        return getName() + " - €" + String.format("%.2f", getPrice()) + " - " + getCalories() + " kcal";
    }
}

package it.epicode.u2s5l4.config;

import it.epicode.u2s5l4.model.*;
import it.epicode.u2s5l4.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    @Autowired private PizzaBaseRepository pizzaBaseRepo;
    @Autowired private ToppingRepository toppingRepo;
    @Autowired private DrinkRepository drinkRepo;

    @PostConstruct
    public void initData() {
        // PIZZE BASE
        PizzaBase margherita = new PizzaBase(null, "Pizza Margherita", 4.99, 1104);
        pizzaBaseRepo.save(margherita);

        // TOPPING
        Topping cheese = new Topping(null, "Cheese", 0.69, 92);
        Topping ham = new Topping(null, "Ham", 0.99, 35);
        Topping onions = new Topping(null, "Onions", 0.69, 22);
        Topping pineapple = new Topping(null, "Pineapple", 0.79, 24);
        Topping salami = new Topping(null, "Salami", 0.99, 86);
        toppingRepo.saveAll(List.of(cheese, ham, onions, pineapple, salami));

        // DRINK
        Drink lemonade = new Drink(null, "Lemonade (0.33l)", 1.29, 128);
        Drink water = new Drink(null, "Water (0.5l)", 1.29, 0);
        Drink wine = new Drink(null, "Wine (0.75l, 13%)", 7.49, 607);
        drinkRepo.saveAll(List.of(lemonade, water, wine));

        System.out.println("✅ Dati inizializzati nel database.");
    }
}


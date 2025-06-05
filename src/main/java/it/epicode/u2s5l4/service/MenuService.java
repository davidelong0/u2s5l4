package it.epicode.u2s5l4.service;

import it.epicode.u2s5l4.model.*;
import it.epicode.u2s5l4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired private PizzaBaseRepository pizzaBaseRepo;
    @Autowired private ToppingRepository toppingRepo;
    @Autowired private DrinkRepository drinkRepo;

    public Menu getMenu() {
        List<Item> pizzas = new ArrayList<>();

        // Prendi tutte le pizze base (ad esempio solo margherita)
        List<PizzaBase> bases = pizzaBaseRepo.findAll();
        pizzas.addAll(bases);

        // Esempio: comporre pizze con topping
        Optional<PizzaBase> margheritaOpt = pizzaBaseRepo.findByName("Pizza Margherita");
        if (margheritaOpt.isEmpty()) {
            throw new RuntimeException("Pizza Margherita non trovata nel DB");
        }
        PizzaBase margherita = margheritaOpt.get();

        // Cerca i toppings
        Optional<Topping> hamOpt = toppingRepo.findByName("Ham");
        Optional<Topping> pineappleOpt = toppingRepo.findByName("Pineapple");
        Optional<Topping> salamiOpt = toppingRepo.findByName("Salami");

        if (hamOpt.isEmpty() || pineappleOpt.isEmpty() || salamiOpt.isEmpty()) {
            throw new RuntimeException("Topping richiesti non trovati nel DB");
        }

        PizzaComposed hawaiian = new PizzaComposed("Hawaiian Pizza", margherita, List.of(hamOpt.get(), pineappleOpt.get()));
        PizzaComposed salamiPizza = new PizzaComposed("Salami Pizza", margherita, List.of(salamiOpt.get()));

        pizzas.add(hawaiian);
        pizzas.add(salamiPizza);

        return new Menu(
                pizzas,
                toppingRepo.findAll(),
                drinkRepo.findAll()
        );
    }
}

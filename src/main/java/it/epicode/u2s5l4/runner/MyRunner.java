package it.epicode.u2s5l4.runner;

import it.epicode.u2s5l4.enumeration.StatoOrdine;
import it.epicode.u2s5l4.model.Menu;
import it.epicode.u2s5l4.model.Order;
import it.epicode.u2s5l4.repository.DrinkRepository;
import it.epicode.u2s5l4.repository.OrderRepository;
import it.epicode.u2s5l4.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private MenuService menuService;

    @Autowired
    private DrinkRepository drinkRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== MENU ===");
        Menu menu = menuService.getMenu();
        System.out.println(menu);

        System.out.println("\n=== DRINKS sotto 2 euro ===");
        List<?> drinksCheap = drinkRepo.findByPriceLessThan(2.0);
        drinksCheap.forEach(System.out::println);

        System.out.println("\n=== ORDINI IN CORSO ===");
        List<Order> ordersInCorso = orderRepo.findByStatoOrdine(StatoOrdine.IN_CORSO);
        ordersInCorso.forEach(System.out::println);
    }
}

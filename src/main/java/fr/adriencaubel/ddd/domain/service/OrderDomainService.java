package fr.adriencaubel.ddd.domain.service;

import fr.adriencaubel.ddd.domain.*;
import org.springframework.stereotype.Service;

@Service
public class OrderDomainService {

    public OrderResult createOrder(Client client, Article article, int quantity, Stock stock, Provider provider) {
        if(stock.getQuantity() < quantity) {
            throw new IllegalStateException("Not enough stock");
        }

        stock.reserve(quantity);

        Mouvement mouvement = new Mouvement(article.getId(), provider, MouvementType.OUTPUT, quantity);

        client.incrementNumberOfOrders();

        Order order = new Order(client.getId());
        order.addOrderLine(article.getId(), quantity);

        return new OrderResult(order, mouvement);
    }
}

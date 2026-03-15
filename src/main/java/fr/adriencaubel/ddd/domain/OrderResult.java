package fr.adriencaubel.ddd.domain;

public class OrderResult {
    public Order order;
    public Mouvement mouvement;

    public OrderResult(Order order, Mouvement mouvement) {
        this.order = order;
        this.mouvement = mouvement;
    }
}

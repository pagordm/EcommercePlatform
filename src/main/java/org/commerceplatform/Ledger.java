package org.commerceplatform;

import java.util.Map;

public class Ledger {

    private final Map<Order, Payment> orders;

    public Ledger(Map<Order, Payment> orders) {
        this.orders=orders;
    }

    public void addOrder(Order o) {
        Payment newPayment = new Payment(o, o.getTotalPrice(), false);
        this.orders.putIfAbsent(o, newPayment);
    }

    public Map<Order, Payment> getOrders() {
        return this.orders;
    }

    public void markAsPaid(Payment p) {
        this.orders.get(p.getOrder()).setPaid(true);
    }

    public Payment getLatestPayment(Customer customer) { //The latest payment is the one not marked as paid.
        return this.orders.values().stream().filter(p -> p.getOrder().getCustomer().equals(customer)).findFirst().get();
    }

    public void removeOrder(Order o) {
        this.orders.remove(o);
    }


}

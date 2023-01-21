package org.commerceplatform;

import java.util.Map;

public class Ledger {

    private final Map<Order, Payment> orders;

    public Ledger(Map<Order, Payment> orders) {
        this.orders=orders;
    }

    public boolean addOrder(Order o, Payment p) {
        if (this.orders.containsKey(o)) return false;
        this.orders.put(o, p);
        return true;
    }

    public Map<Order, Payment> getOrders() {
        return this.orders;
    }


}

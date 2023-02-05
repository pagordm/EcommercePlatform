package org.commerceplatform;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<OrderDetail> items; //ID of carted items
    private final Customer customer;

    public Cart (Customer c) {
        this.customer=c;
        this.items = new ArrayList<>();
    }

    public Order checkout() {
        return new Order(this.items.toArray(new OrderDetail[0]), this.customer);
    }

    public void addItemToCart(Item i, int qty) {
        this.items.add(new OrderDetail(i, qty));
    }

}

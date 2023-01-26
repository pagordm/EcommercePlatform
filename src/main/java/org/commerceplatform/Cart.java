package org.commerceplatform;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cart {
    private Customer customer;

    private List<OrderDetail> items; //ID of carted items (with duplicates for qty)

    public Cart (Customer c) {
        this.customer = c;
        this.items = new ArrayList<>();
    }

    public Order checkout() {
        return new Order(this.items.toArray(new OrderDetail[0]));
    }

    public void addItemToCart(Item i, int qty) {
        this.items.add(new OrderDetail(i, qty));
    }

}

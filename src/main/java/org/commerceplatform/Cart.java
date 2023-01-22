package org.commerceplatform;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cart {
    private Optional<Customer> customer;

    private List<Item> items; //ID of carted items (with duplicates for qty)
    boolean isLoggedIn;

    public Cart (Customer c) {
        this.customer = Optional.of(c);
        this.isLoggedIn = true;
        this.items = new ArrayList<>();
    }

    public Cart() {
        this.customer = Optional.empty();
        this.isLoggedIn = false;
        this.items = new ArrayList<>();
    }

    public Order checkout() {
        List<OrderDetail> list = new ArrayList<>();
        for(Item i : this.items.stream().distinct().toList()) {
            list.add(new OrderDetail(i, (int) this.items.stream().filter(i::equals).count()));
        }
        return new Order(list.toArray(new OrderDetail[0]));
    }

    public void addItemToCart(Item i) {
        this.items.add(i);
    }

    public List<Item> getItemList() {
        return this.items;
    }
}

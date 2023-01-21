package org.commerceplatform;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private Optional<Customer> customer;

    Item[] items; //ID of carted items (with duplicates for qty)
    boolean isLoggedIn;

    public Cart (Customer c) {
        this.customer = Optional.of(c);
        this.isLoggedIn = true;
    }

    public Cart() {
        this.customer = Optional.empty();
        this.isLoggedIn = false;
    }

    public Order checkout() {
        List<OrderDetail> list = new ArrayList<>();
        for(Item i : this.items) {
            if (list.stream().noneMatch(o -> o.getItem().equals(i))) {
                list.add(new OrderDetail(i, 1));
            } else {
                int index = list.indexOf(list.stream().filter(o -> o.getItem().equals(i)).findFirst().get());
                list.get(index).changeAmount(list.get(index).getQty()+1);
            }
        }
        return new Order(list.toArray(new OrderDetail[0]));
    }

}

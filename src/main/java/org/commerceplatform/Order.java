package org.commerceplatform;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    int OrderId;

    private Customer customer;
    public static int lastId = 1;
    Date createDate;
    private OrderDetail[] details;

    public Order(OrderDetail[] details, Customer c) {
        this.createDate = new Date(); //Current time
        this.OrderId = lastId;
        this.details = details;
        this.customer = c;
        lastId++;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (OrderDetail o :
                details) {
            sum += o.getTotalPrice();
        }
        return sum;
    }

    public List<Item> getItemList() {
        return Arrays.stream(this.details).map(OrderDetail::getItem).collect(Collectors.toList());
    }

    public int getQty(Item i) {
        for (OrderDetail o :
                this.details) {
            if (o.getItem().equals(i)) return o.getQty();
        }
        return -1;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public int getSalesForItem(int id) {
        int i = 0;
        for(OrderDetail od : this.details) {
            if (od.getItem().getId()==id) {
                i += od.getQty();
            }
        }
        return i;
    }
}

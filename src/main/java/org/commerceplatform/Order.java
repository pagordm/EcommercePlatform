package org.commerceplatform;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    int OrderId;

    public static int lastId = 1;
    Date createDate;
    private OrderDetail[] details;

    public Order(OrderDetail[] details) {
        this.createDate = new Date(); //Current time
        this.OrderId = lastId;
        this.details = details;
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
}

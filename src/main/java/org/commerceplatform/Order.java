package org.commerceplatform;

import java.util.Arrays;
import java.util.Date;
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
}

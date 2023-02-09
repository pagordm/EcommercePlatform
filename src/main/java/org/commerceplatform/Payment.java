package org.commerceplatform;

public class Payment {
    private double amount;

    private Order order;

    private boolean isPaid;

    public Payment(Order order, double amount, boolean isPaid) {
        this.order = order;
        this.amount = amount;
        this.isPaid = isPaid;
    }


    public Order getOrder() {
        return this.order;
    }

    public void setPaid(boolean b) {
        this.isPaid=b;
    }

    public boolean isPaid() {
        return this.isPaid;
    }
}

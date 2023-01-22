package org.commerceplatform;

public class Payment {
    private double amount;

    private Order order;

    public Payment(Order order, double amount, boolean isPaid) {
        this.order = order;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    private boolean isPaid;

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return this.isPaid;
    }

    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }

}

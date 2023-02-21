package org.commerceplatform;

import java.util.List;

public class Ledger {

    private final List<Payment> payments;

    public Ledger(List<Payment> payments) {
        this.payments = payments;
    }

    public void addPayment(Order order) {
        Payment newPayment = new Payment(order, order.getTotalPrice(), false);
        this.payments.add(newPayment);
    }

    public Payment getLatestPayment(Customer c) {
        for(Payment o : this.payments) {
            if (o.getOrder().getCustomer().equals(c) && !o.isPaid())
                return o;
        }
        return null;
    }

    public void removePayment(Payment o) {
        this.payments.remove(o);
    }

    public void removeLatestPayment(Customer c) {
        this.removePayment(this.getLatestPayment(c));
    }

    public double getTotalSales() {
        double amount = 0;
        for(Payment p : this.payments) {
            amount += p.getAmount();
        }
        return amount;
    }

    public int getSalesForItem(int id) {
        int i = 0;
        for(Payment p : this.payments) {
            i += p.getOrder().getSalesForItem(id);
        }
        return i;
    }


}

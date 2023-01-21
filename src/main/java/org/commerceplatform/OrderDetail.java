package org.commerceplatform;

public class OrderDetail {
    private Item item;
    private int qty;

    public OrderDetail(Item item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    public double getTotalPrice() {
        return item.getPrice()*qty;
    }

    public void changeAmount(int newQty) {
        this.qty=newQty;
    }

    public int getQty() {
        return this.qty;
    }

    public Item getItem() {
        return this.item;
    }
}

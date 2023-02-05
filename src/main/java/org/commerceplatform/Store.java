package org.commerceplatform;

import org.commerceplatform.data.DataLoader;

public class Store {
    private int id;
    private Ledger ledger;
    private ItemCatalogue catalogue;

    public Store(int id) {
        this.id=id;
        this.catalogue=new ItemCatalogue(DataLoader.getItemCatalogueData());
        this.ledger=new Ledger(DataLoader.getLedgerData(this.catalogue));

    }


    public void addItemToUserCart(Customer c, Item i, int qty) {
        c.getUserCart().addItemToCart(i, qty);
    }

    public Item getItemFromId(int id) {
        return this.catalogue.getItemFromId(id);
    }

    public int getStock(Item i) {
        return this.catalogue.getStock(i);
    }

    public void checkout(Customer c) {
        Order o = c.getUserCart().checkout();
        Payment newPayment = new Payment(o, o.getTotalPrice(), false);
        this.ledger.addOrder(newPayment);
    }

    public Order getCheckoutCart(Customer c) {
        return this.ledger.getLatestPayment(c).getOrder();
    }

    public void payOrder(Customer c) {
        //Payment logic would go here...

        this.ledger.markAsPaid(this.ledger.getLatestPayment(c));
    }

    public void removeLatestOrder(Customer c) {
        this.ledger.removeOrder(this.ledger.getLatestPayment(c).getOrder());
    }
}

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


    public ItemCatalogue getItemCatalogue() {
        return this.catalogue;
    }

    public void checkout(Customer c) {
        Order o = c.getUserCart().createOrder();
        this.ledger.addPayment(o);
    }

    public Ledger getLedger() {
        return this.ledger;
    }


}

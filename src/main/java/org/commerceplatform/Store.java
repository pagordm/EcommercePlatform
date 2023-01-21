package org.commerceplatform;

public class Store {
    private int id;
    private Ledger ledger;
    private ItemCatalogue catalogue;

    public Store(int id, Ledger ledger, ItemCatalogue catalogue) {
        this.id=id;
        this.ledger=ledger;
        this.catalogue=catalogue;
    }
}

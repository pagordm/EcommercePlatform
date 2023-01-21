package org.commerceplatform;

import org.commerceplatform.data.DataLoader;

public class Main {
    public static void main(String[] args) {
        ItemCatalogue items = new ItemCatalogue(DataLoader.getItemCatalogueData());
        Ledger l = new Ledger(DataLoader.getLedgerData(items));
        Store ourStore = new Store(1, l, items);

        //Create a new customer
        Customer c = new Customer("foo", "bar");
    }
}
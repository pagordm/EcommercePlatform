package org.commerceplatform;

import java.util.HashMap;
import java.util.Map;

public class DataCollector {

    private final Ledger l;
    private final ItemCatalogue ic;

    DataCollector(Ledger l, ItemCatalogue ic) {
        this.l=l;
        this.ic=ic;
    }
    public double getTotalSales() {
        return this.l.getTotalSales();
    }

    public Map<Item, Integer> getBestItems() {
        Map<Item, Integer> list = new HashMap<>();
        for(Item i : this.ic.stock.keySet()) {
            list.putIfAbsent(i, this.l.getSalesForItem(i.getId()));
        }
        return list;
    }
}

package org.commerceplatform;

import java.util.*;

public class ItemCatalogue {

    Map<Item, Integer> stock;

    public ItemCatalogue(Map<Item, Integer > stock) {
        this.stock = stock;
    }

    public Item getItemFromId(int ID) {
        for(Item i : this.stock.keySet()) {
            if (i.getId()==ID) return i;
        }
        return null;
    }

    public int getStock(Item i) {
        return stock.get(i);
    }

}

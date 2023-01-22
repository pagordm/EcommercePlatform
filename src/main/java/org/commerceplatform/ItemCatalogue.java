package org.commerceplatform;

import java.util.Map;
import java.util.Optional;

public class ItemCatalogue {

    Map<Item, Integer> stock; // [ID, Stock]

    public ItemCatalogue(Map<Item, Integer > stock) {
        this.stock = stock;
    }

    public Item getItemFromId(int ID) {
        Optional<Item> item = stock.keySet().stream().filter(i -> i.getId()==ID).findFirst();
        if (item.isEmpty()) return null;
        return item.get();
    }

    public int getStock(Item i) {
        return stock.get(i);
    }
}

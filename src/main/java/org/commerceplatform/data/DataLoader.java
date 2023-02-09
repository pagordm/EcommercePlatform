package org.commerceplatform.data;

import org.commerceplatform.*;

import java.text.DecimalFormat;
import java.util.*;

public class DataLoader {

    public static final String[] ITEM_NAMES = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"};
    private static final String ITEM_DESC = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static final List<Item> ITEM_LIST = new ArrayList<>();
    public static Map<Item, Integer> getItemCatalogueData() {
        Random r = new Random();
        Map<Item, Integer> map = new HashMap<>();
        int id = 0;
        for(String name : ITEM_NAMES) {

            double price = r.nextDouble()*50;


            Item i = new Item(id ,price, ITEM_NAMES[id], ITEM_DESC);
            int stock = r.nextInt(0, 100);
            if (id % 3 == 0) {
                stock = 0;
            }
            id++;
            map.put(i, stock);
            ITEM_LIST.add(i);
        }
        return map;
    }

    public static List<Payment> getLedgerData(ItemCatalogue items) {
        Random r = new Random();
        List<Payment> data = new ArrayList<>();
        int order_amount = r.nextInt(5,20);
        for (int i = 0; i < order_amount; i++) {

            int details_amount = r.nextInt(1, 5);
            OrderDetail[] details = new OrderDetail[details_amount];
            for (int j = 0; j < details_amount; j++) {
                details[j] = new OrderDetail(items.getItemFromId(r.nextInt(ITEM_NAMES.length)), r.nextInt(1, 10));
            }

            Order o = new Order(details, new Customer("foo", "bar"));
            Payment p = new Payment(o, o.getTotalPrice(), true);

            data.add(p);
        }
        return data;
    }
}

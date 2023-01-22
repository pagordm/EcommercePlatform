package org.commerceplatform;

import org.commerceplatform.data.DataLoader;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static final boolean error = false;
    public static void main(String[] args) {
        ItemCatalogue items = new ItemCatalogue(DataLoader.getItemCatalogueData());
        Ledger l = new Ledger(DataLoader.getLedgerData(items));
        Store ourStore = new Store(1, l, items);

        //Create a new customer
        Customer c = new Customer("foo", "bar");

        //Show items
        int i = 1;
        for(Item item : DataLoader.ITEM_LIST) {
            System.out.println(i + ".- " + item.getName());
            System.out.println(item.getDescription());
            System.out.println(formatDouble(item.getPrice()) + "€");
            System.out.println("Stock: " + items.getStock(item));
            System.out.println("--------------------------");
            i++;
        }

        Scanner k = new Scanner(System.in);
        while(true) {
            System.out.println("Introduce the item you want to buy (or 0 to proceed to checkout)");
            System.out.print("> ");
            int selected = k.nextInt();
            if (selected == 0) break;
            Item toAdd = items.getItemFromId(selected-1);
            if (toAdd != null) {
                System.out.print("Choose a qty: ");

                int qty = k.nextInt();
                if (items.getStock(toAdd) < qty) {
                    System.out.println("Not enough of this item is available!");
                    continue;
                }
                for (int j = 0; j < qty; j++) {
                    c.getUserCart().addItemToCart(toAdd);
                }
                System.out.println("Added " + qty + "x " + toAdd.getName() + " to the user cart.");
            }
            else
                System.out.println("The item selected does not exist, try again");

        }
        System.out.println("Your cart: ");
        Order newOrder = c.getUserCart().checkout();
        for(Item item : newOrder.getItemList()) {
            System.out.println(item.getName() + " x" + newOrder.getQty(item) + " : " + formatDouble(item.getPrice()* newOrder.getQty(item)) + "€");
        }
        System.out.println("Total: " + formatDouble(newOrder.getTotalPrice()) + "€");
        System.out.println("Do you want to proceed? y/N");
        System.out.print("> ");
        k.nextLine();
        boolean proceed = k.nextLine().toLowerCase().equals("y");
        if (!proceed) return; //STOP

        //TODO: Add some kind of payment processor?
        System.out.println("Redirecting you to the payment processor...");

        //We add the purchase to the ledger:
        if (error) { //Simulate if there has been an error (or delay in the payment)
            System.out.println("An error on the payment has ocurred.");
            System.out.println("The payment will be automatically retried, your order is already confirmed.");
            l.addOrder(newOrder, new Payment(newOrder, newOrder.getTotalPrice(), false));
            //TODO: retry payment?
        } else {

            System.out.println("Done, confirming order...");
            l.addOrder(newOrder, new Payment(newOrder, newOrder.getTotalPrice(), true));
        }
    }

    public static String formatDouble(double d) {
        return new DecimalFormat("#0.00").format(d);
    }
}
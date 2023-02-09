package org.commerceplatform;

import org.commerceplatform.data.DataLoader;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static final boolean error = false;
    public static void main(String[] args) {
        Store ourStore = new Store(1);

        //Create a new customer
        Customer c = new Customer("foo", "bar");

        //Show items
        int i = 1;
        for(Item item : DataLoader.ITEM_LIST) {
            System.out.println(i + ".- " + item.getName());
            System.out.println(item.getDescription());
            System.out.println(formatDouble(item.getPrice()) + "€");
            System.out.println("Stock: " + ourStore.getItemCatalogue().getStock(item));
            System.out.println("--------------------------");
            i++;
        }

        Scanner k = new Scanner(System.in);
        while(true) {
            System.out.println("Introduce the item you want to buy (or 0 to proceed to checkout)");
            System.out.print("> ");
            int selected = k.nextInt();
            if (selected == 0) break;
            Item toAdd = ourStore.getItemCatalogue().getItemFromId(selected-1);
            if (toAdd != null) {
                System.out.print("Choose a qty: ");

                int qty = k.nextInt();
                if (ourStore.getItemCatalogue().getStock(toAdd) < qty) {
                    System.out.println("Not enough of this item is available!");
                    continue;
                }
                c.getUserCart().addItemToCart(toAdd, qty);

                System.out.println("Added " + qty + "x " + toAdd.getName() + " to the user cart.");
            }
            else
                System.out.println("The item selected does not exist, try again");

        }
        System.out.println("Your cart: ");
        ourStore.checkout(c);
        Order checkoutOrder = c.getUserCart().createOrder();
        for(Item item : checkoutOrder.getItemList()) {
            System.out.println(item.getName() + " x" + checkoutOrder.getQty(item) + " : " + formatDouble(item.getPrice()* checkoutOrder.getQty(item)) + "€");
        }
        System.out.println("Total: " + formatDouble(checkoutOrder.getTotalPrice()) + "€");
        System.out.println("Do you want to proceed? y/N");
        System.out.print("> ");
        k.nextLine();
        boolean proceed = k.nextLine().equalsIgnoreCase("y");
        if (!proceed) return; //STOP

        //We add the purchase to the ledger:
        if (error) { //Simulate if there has been an error (or delay in the payment)
            System.out.println("An error on the payment has ocurred.");
            System.out.println("The order has been cancelled.");

            ourStore.removeLatestOrder(c);
        } else {

            System.out.println("Done, confirming order...");
            ourStore.payOrder(c);
        }
    }

    public static String formatDouble(double d) {
        return new DecimalFormat("#0.00").format(d);
    }
}
package org.commerceplatform;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        Store s = new Store(0);
        Admin a = new Admin("foo", "bar");

        DashboardHandler handler = new DashboardHandler(s);

        handler.requestStatistics(a);
        handler.showStats();
        handler.editStats(0);
        handler.showStats();
    }

    public static String formatDouble(double d) {
        return new DecimalFormat("#0.00").format(d);
    }
}
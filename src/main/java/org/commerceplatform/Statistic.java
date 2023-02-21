package org.commerceplatform;

public abstract class Statistic {

    private final int id;

    public static int LAST_ID = 0;

    public abstract String getDisplayString();

    public Statistic() {
        this.id=LAST_ID;
        LAST_ID++;
    }

    public int getId() {
        return this.id;
    }


}

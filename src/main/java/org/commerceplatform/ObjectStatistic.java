package org.commerceplatform;

public class ObjectStatistic extends Statistic{

    private final Object o;

    public ObjectStatistic(Object o) {
        this.o=o;
    }
    @Override
    public String getDisplayString() {
        return this.o.toString();
    }
}

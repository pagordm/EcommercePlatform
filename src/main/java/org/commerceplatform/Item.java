package org.commerceplatform;

public class Item {
    private int id;
    private double price;
    private String name;
    private String description;

    public Item(int id, double price, String name, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item item) {
            return item.getId() == this.getId();
        }
        return false;
    }
}

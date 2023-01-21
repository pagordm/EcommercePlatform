package org.commerceplatform;

public class Customer {

    private Cart userCart;
    private String password;
    private String[] viewedItems;
    private String username;
    private String[] cartedItems;
    private String[] boughtItems;

    private int id;

    public Customer(String username, String password) {
        this.username=username;
        this.password=password;

        this.userCart=new Cart(this);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}

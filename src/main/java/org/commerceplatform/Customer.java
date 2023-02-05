package org.commerceplatform;

public class Customer extends User{

    private Cart userCart;

    public Customer(String username, String password) {
        super(username, password);

        this.userCart=new Cart(this);
    }

    public Cart getUserCart() {
        return this.userCart;
    }
}

package org.commerceplatform;

public class User {
    private String username;
    private String password;
    private int id;
    private static int last_id = 0;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = last_id;
        last_id++;
    }


}

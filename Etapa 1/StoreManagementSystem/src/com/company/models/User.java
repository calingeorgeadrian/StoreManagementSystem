package com.company.models;

public class User {
    protected int userId;
    protected String username;
    protected String password;
    protected String type;

    public User(int id, String username, String password, String type) {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public void printInfo() {
        System.out.println("User id: " + this.userId);
        System.out.println("Username: " + this.username);
        System.out.println("Password: " + this.password);
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

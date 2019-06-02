package com.company.models;

import java.util.Date;

public class Customer extends User {
    private Date registrationDate;
    private Date lastActive;
    private String name;
    private String email;
    private String phoneNumber;
    private Address location;
    private Address shippingInfo;
    private Card creditCard;

    public Customer(int id, String username, String password, String type, Date registrationDate, Date lastActive, String name, String email, String phoneNumber, Address address, Address shippingInfo, Card creditCard) {
        super(id, username, password, type);
        this.registrationDate = registrationDate;
        this.lastActive = lastActive;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = address;
        this.shippingInfo = shippingInfo;
        this.creditCard = creditCard;
    }

    public Customer() {
        super(1, "Customer", "password", "customer");
        this.registrationDate = new Date();
        this.lastActive = new Date();
        this.name = "Default Customer";
        this.email = "email@email.com";
        this.phoneNumber = "0741234567";
        this.location = new Address();
        this.shippingInfo = new Address();
        this.creditCard = new Card();
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Customer name: " + this.name);
        System.out.println("Customer email: " + this.email);
        System.out.println("Customer phone: " + this.phoneNumber);
        System.out.println("Customer registration date: " + this.registrationDate);
        System.out.println("Customer last active date: " + this.lastActive);
        System.out.println("\nLocation");
        this.location.printInfo();
        System.out.println("\nShipping Info");
        this.shippingInfo.printInfo();
        System.out.println("\nCredit Card");
        this.creditCard.printInfo();
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(Address shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public Card getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Card creditCard) {
        this.creditCard = creditCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

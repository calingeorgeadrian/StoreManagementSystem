package com.company.models;

import java.util.Date;

public class Card {
    private String number;
    private Date expirationDate;
    private int cvc;

    public Card(String number, Date expirationDate, int cvc) {
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
    }

    public Card() {
        this.number = "0000 0000 0000 0000";
        this.expirationDate = new Date(2021, 4,1);
        this.cvc = 1234;
    }

    public void printInfo() {
        System.out.println("Card number: " + this.number);
        System.out.println("Card cvc: " + this.cvc);
        System.out.println("Card expiration date: " + this.expirationDate.getMonth() + "/" + this.expirationDate.getDate() + "/" + this.expirationDate.getYear());
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}

package com.company.models;

import java.util.Arrays;

public class Order {
    private int orderId;
    private int providerId;
    private ProductEntry[] entries;

    public Order(int orderId, int providerId, ProductEntry[] entries) {
        this.orderId = orderId;
        this.providerId = providerId;
        this.entries = entries;
        this.sortEntries();
    }

    public void printInfo() {
        this.sortEntries();
        System.out.println("\nOrder Id: " + this.orderId);
        for (ProductEntry entry : entries)
            entry.printInfo();
        System.out.println("\nOrder value: " + calculateValue());
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public ProductEntry[] getEntries() {
        return entries;
    }

    public void setEntries(ProductEntry[] entries) {
        this.entries = entries;
    }

    private void sortEntries() {
        Arrays.sort(entries);
    }

    public double calculateValue() {
        double sum = 0;
        for(ProductEntry entry: entries)
            sum += entry.getCost();

        return sum;
    }
}

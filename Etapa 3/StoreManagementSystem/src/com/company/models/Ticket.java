package com.company.models;

import java.util.Date;
import java.util.List;

public class Ticket {
    private int id;
    private List<ProductEntry> entries;
    private double total;
    private Cashier cashier;
    private Date date;

    public Ticket(int id, List<ProductEntry> entries, Cashier cashier, Date date) {
        this.id = id;
        this.entries = entries;
        this.cashier = cashier;
        this.date = date;
        this.total = calculateTotal();
    }

    public void printInfo() {
        for (ProductEntry entry : entries) {
            Product product = entry.getProduct();
            double entryPrice = entry.getQuantity() * product.getPricePerUnit();
            System.out.println(entry.getQuantity() + " x " + product.getName() + "\t" + entryPrice + " RON");
        }
        System.out.println("TOTAL: " + this.total + " RON");
        System.out.println("Cashier: " + this.cashier.getName());
        System.out.println("Date: " + this.date);
        System.out.println("Ticket Id: " + this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductEntry>  getEntries() {
        return entries;
    }

    public void setEntries(List<ProductEntry>  entries) {
        this.entries = entries;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private double calculateTotal() {
        double sum = 0;
        for (ProductEntry entry : entries)
            sum += entry.getQuantity() * entry.getProduct().getPricePerUnit();
        return sum;
    }

    public void addEntry(ProductEntry entry) {
        this.entries.add(entry);
        this.total = calculateTotal();
    }
}

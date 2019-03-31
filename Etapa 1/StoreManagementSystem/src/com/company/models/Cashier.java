package com.company.models;

import java.util.Date;

public class Cashier extends User {
    private String name;
    private Date hireDate;
    private Date endDate;

    public Cashier(int id, String username, String password, String type, String name, Date hireDate, Date endDate) {
        super(id, username, password, type);
        this.name = name;
        this.hireDate = hireDate;
        this.endDate = endDate;
    }

    public Cashier(int id, String username, String password, String type, String name, Date hireDate) {
        super(id, username, password, type);
        this.name = name;
        this.hireDate = hireDate;
        this.endDate = null;
    }

    public Cashier() {
        super(0, "Cashier", "password", "cashier");
        this.name = "Default Cashier";
        this.hireDate = new Date();
        this.endDate = null;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Cashier name: " + this.name);
        System.out.println("Cashier hire date: " + this.hireDate);
        if (endDate == null)
            System.out.println("Cashier end date: still hired");
        else
            System.out.println("Cashier end date: " + this.endDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

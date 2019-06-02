package com.company.models;

public class PackageType implements Cloneable {
    private int id;
    private String name;
    private String description;
    private double quantity;
    private String measureUnit;

    public PackageType(int id, String name, String description, double quantity, String measureUnit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
    }

    public void printInfo() {
        System.out.println("Product container: " + this.name);
        System.out.println("Product container description: " + this.description);
        System.out.println("Product container quantity: " + this.quantity);
        System.out.println("Product container measure unit: " + this.measureUnit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

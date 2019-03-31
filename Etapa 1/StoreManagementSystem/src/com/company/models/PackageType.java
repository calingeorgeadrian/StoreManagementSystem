package com.company.models;

public class PackageType implements Cloneable {
    private String name;
    private String description;
    private double quantity;
    private String measureUnit;

    public PackageType(String name, String description, double quantity, String measureUnit) {
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

}

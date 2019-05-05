package com.company.models;

public class Product implements Cloneable {
    private int id;
    private String name;
    private ProductCategory category;
    private PackageType container;
    private double pricePerUnit;
    private int stock;

    public Product(int id, String name, ProductCategory category, PackageType container, double ppu, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.container = container;
        this.pricePerUnit = ppu;
        this.stock = stock;
    }

    public void printInfo() {
        System.out.println("Product id: " + this.id);
        System.out.println("Product name: " + this.name);
        System.out.println("Product price: " + this.pricePerUnit);
        System.out.println("Product stock: " + this.stock);
        this.category.printInfo();
        this.container.printInfo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PackageType getContainer() {
        return container;
    }

    public void setPackage(PackageType container) {
        this.container = container;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double ppu) {
        this.pricePerUnit = ppu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}

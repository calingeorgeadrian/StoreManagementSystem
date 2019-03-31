package com.company.models;

public class ProductCategory implements Cloneable {
    private int id;
    private String name;
    private String description;

    public ProductCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void printInfo() {
        System.out.println("Product category: " + this.id);
        System.out.println("Product category name: " + this.name);
        System.out.println("Product category description: " + this.description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

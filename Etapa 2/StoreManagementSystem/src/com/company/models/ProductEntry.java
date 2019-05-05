package com.company.models;

public class ProductEntry implements Comparable<ProductEntry> {
    private Product product;
    private int quantity;

    public ProductEntry(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductEntry(ProductEntry entry) {
        this.product = entry.product;
        this.quantity = entry.quantity;
    }

    public void printInfo() {
        System.out.println(this.product.getName() + " " + this.quantity + "buc " + this.getCost() + "RON");
       /* System.out.println("Quantity: " + this.quantity);
        System.out.println("Cost: " + this.getCost());*/
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        double cost = this.quantity * this.product.getPricePerUnit();
        return cost;
    }

    @Override
    public int compareTo(ProductEntry entry) {
        return Double.compare(getCost(), entry.getCost());
    }
}

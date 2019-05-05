package com.company.models;

public class Provider extends User {
    private int registrationId;
    private String name;
    private Order[] orders;

    public Provider(int id, String username, String password, String type, int registrationId, String name, Order[] orders) {
        super(id, username, password, type);
        this.registrationId = registrationId;
        this.name = name;
        this.orders = orders;
    }

    public Provider() {
        super(1, "Provider", "password", "provider");
        this.registrationId = 1234;
        this.name = "Default Provider";
        this.orders = null;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Provider registration Id: " + this.registrationId);
        System.out.println("Provider name: " + this.name);
    }

    public void printOrders() {
        if(orders != null){
            for (Order order : orders)
                order.printInfo();
        }
        else
            System.out.println("No orders found.");
    }

    public void printOrderById(int id) {
        if(orders != null){
            for (Order order : orders)
                if(order.getOrderId() == id)
                    order.printInfo();
        }
        else
            System.out.println("No orders found.");
    }

    public void printOrdersValue() {
        double sum = 0;
        if(orders != null){
            for (Order order : orders)
                sum += order.calculateValue();
        }
        else
            System.out.println("No orders found.");

        System.out.println("Total worth: " + sum + "RON");
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int id) {
        this.registrationId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }
}

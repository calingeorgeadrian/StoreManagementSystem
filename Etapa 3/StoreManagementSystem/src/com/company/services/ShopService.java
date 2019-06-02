package com.company.services;

import com.company.models.PackageType;
import com.company.models.Product;
import com.company.models.ProductCategory;
import com.company.models.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ShopService {
    private static ShopService myInstance = new ShopService();

    public static ShopService getInstance() {
        return myInstance;
    }

    private static final ArrayList<Product> listOfProducts = new ArrayList<Product>();
    private static final ArrayList<ProductCategory> listOfCategories = new ArrayList<ProductCategory>();
    private static final ArrayList<PackageType> listOfPackages = new ArrayList<PackageType>();
    private static final ArrayList<Ticket> listOfTickets = new ArrayList<Ticket>();

    private ShopService() {

    }

    public  void printProductsStock() {
        System.out.println("Code\tName\tStock");
        for(Product product: listOfProducts)
            System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getStock() + "buc");
    }

    public  void printProductById(int id) {
        for(Product product: listOfProducts)
            if(product.getId() == id)
                product.printInfo();
    }

    public  void printTickets() {
        for(Ticket ticket: listOfTickets) {
            ticket.printInfo();
            System.out.println();
        }
    }

    public  void printTicketById(int id) {
        for(Ticket ticket: listOfTickets)
            if(ticket.getId() == id)
                ticket.printInfo();
    }

    public  void printMenu() {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("\nMENU");
            System.out.println("[1] Print stock");
            System.out.println("[2] Print product by id");
            System.out.println("[3] Add new product");
            System.out.println("[4] Update product stock");
            System.out.println("[5] Delete product");
            System.out.println("[6] Print tickets");
            System.out.println("[7] Print ticket by id");
            System.out.println("[8] Exit");
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice < 1 || choice > 8)
                System.out.println("Option does not exist.");
            else
                switch(choice){
                    case 1: {
                        System.out.println();
                        AuditService.getInstance().addActivity("User printed the stocks.", new Date());
                        printProductsStock();
                    }
                    break;
                    case 2: {
                        int id;
                        System.out.println();
                        System.out.print("Product id: ");
                        id = keyboard.nextInt();
                        keyboard.nextLine();
                        AuditService.getInstance().addActivity("User printed the stock for product with id " + id + ".", new Date());
                        try {
                            DbService.getInstance().selectProductById(id);
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                    case 3: {
                        System.out.print("Product name: ");
                        String name = keyboard.nextLine();
                        System.out.print("Product category id: ");
                        int category = keyboard.nextInt();
                        System.out.print("Product package id: ");
                        int packageType = keyboard.nextInt();
                        System.out.print("Product price: ");
                        double price = keyboard.nextDouble();
                        System.out.print("Stock: ");
                        int stock = keyboard.nextInt();

                        AuditService.getInstance().addActivity(name + " has been added to the database.", new Date());
                        DbService.getInstance().insertProduct(name, category, packageType, price, stock);
                    }
                    break;
                    case 4: {
                        System.out.print("Product id: ");
                        int id = keyboard.nextInt();
                        System.out.print("New stock: ");
                        int stock = keyboard.nextInt();

                        AuditService.getInstance().addActivity("Stock for product with id " + id + " has been updated to " + stock, new Date());
                        DbService.getInstance().updateProductStockById(id, stock);
                    }
                    break;
                    case 5: {
                        System.out.print("Product id: ");
                        int id = keyboard.nextInt();

                        AuditService.getInstance().addActivity("Product with id " + id + " has been removed from the database.", new Date());
                        DbService.getInstance().deleteProductById(id);
                    }
                    break;
                    case 6: {
                        System.out.println();
                        AuditService.getInstance().addActivity("User printed all tickets.", new Date());
                        printTickets();
                    }
                    break;
                    case 7: {
                        int id;
                        System.out.println();
                        System.out.print("Ticket id: ");
                        id = keyboard.nextInt();
                        keyboard.nextLine();
                        AuditService.getInstance().addActivity("User printed the ticket with id " + id + ".", new Date());
                        printTicketById(id);
                    }
                    break;
                    case 8: {
                        return;
                    }
                }
        }
    }

    public void addPackageType(PackageType packageType) {
        listOfPackages.add(packageType);
    }

    public void addProductCategory(ProductCategory category) {
        listOfCategories.add(category);
    }

    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    public void addTicket(Ticket ticket) {
        listOfTickets.add(ticket);
    }

    public ArrayList<ProductCategory> getCategories() {
        return listOfCategories;
    }

    public ArrayList<PackageType> getPackages() {
        return listOfPackages;
    }

    public ArrayList<Product> getProducts() {
        return listOfProducts;
    }
}

package com.company.services;

import com.company.models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShopService {
    private static ShopService myInstance = new ShopService();

    public static ShopService getInstance() {
        return myInstance;
    }

    private static Product[] listOfProducts;
    private static Ticket[] listOfTickets;

    private ShopService() {
        ProductCategory softDrink = new ProductCategory(1, "Soft drinks", "For non-alcoholic drinks such as water or juice");
        ProductCategory alcoholic = new ProductCategory(2, "Alcoholic beverages", "For alcoholic drinks such as beer or wine");
        ProductCategory dairy = new ProductCategory(3, "Dairy products", "For dairy products such as milk, cheese, butter");
        ProductCategory hotDrinks = new ProductCategory(4, "Hot drinks", "For hot drinks such as coffee and tea");
        PackageType bottle = new PackageType("Bottle", "For liquids", 2, "L");
        PackageType glassBottle = new PackageType("Glass Bottle", "For liquids", 330, "ml");
        PackageType box = new PackageType("Box", "For liquids", 900, "ml");
        PackageType bag = new PackageType("Bag", "For solid products", 1, "Kg");
        Product cocaCola = new Product(1, "Coca-Cola", softDrink, bottle, 5.67, 45);
        Product fanta = new Product(2, "Fanta", softDrink, bottle, 5.07, 13);
        Product heineken = new Product(3, "Heineken", alcoholic, glassBottle, 3.42, 28);
        Product milk = new Product(4, "Milk", dairy, box, 4.05, 87);
        Product cheese = new Product(5, "Cheese", dairy, bag, 17.54, 5);
        Product coffee = new Product(6, "Coffee", hotDrinks, bag, 35.6, 27);
        listOfProducts = new Product[6];
        listOfProducts[0] = cocaCola;
        listOfProducts[1] = fanta;
        listOfProducts[2] = heineken;
        listOfProducts[3] = milk;
        listOfProducts[4] = cheese;
        listOfProducts[5] = coffee;

        ProductEntry pEntry1 = new ProductEntry(cocaCola, 17);
        ProductEntry pEntry2 = new ProductEntry(fanta, 12   );
        ProductEntry pEntry3 = new ProductEntry(heineken, 5);
        ProductEntry pEntry4 = new ProductEntry(milk, 5);
        ProductEntry pEntry5 = new ProductEntry(cheese, 5);
        ProductEntry pEntry6 = new ProductEntry(coffee, 5);
        List<ProductEntry> ticketEntries1 = new ArrayList<ProductEntry>();
        List<ProductEntry> ticketEntries2 = new ArrayList<ProductEntry>();
        ticketEntries1.add(pEntry1);
        ticketEntries1.add(pEntry2);
        ticketEntries1.add(pEntry3);
        ticketEntries2.add(pEntry4);
        ticketEntries2.add(pEntry5);
        ticketEntries2.add(pEntry6);
        ticketEntries2.add(pEntry2);
        Ticket ticket1 = new Ticket(1,ticketEntries1, new Cashier(), new Date());
        Ticket ticket2 = new Ticket(2,ticketEntries2, new Cashier(), new Date());
        listOfTickets = new Ticket[2];
        listOfTickets[0] = ticket1;
        listOfTickets[1] = ticket2;
    }

    public static void printProductsStock() {
        System.out.println("Code\tName\tStock");
        for(Product product: listOfProducts)
            System.out.println(product.getCode() + "\t" + product.getName() + "\t" + product.getStock() + "buc");
    }

    public static void printProductByCode(int code) {
        for(Product product: listOfProducts)
            if(product.getCode() == code)
                product.printInfo();
    }

    public static void printTickets() {
        for(Ticket ticket: listOfTickets) {
            ticket.printInfo();
            System.out.println();
        }
    }

    public static void printTicketById(int id) {
        for(Ticket ticket: listOfTickets)
            if(ticket.getTicketId() == id)
                ticket.printInfo();
    }

    public static void printMenu() {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("\nMENU");
            System.out.println("[1] Print stock");
            System.out.println("[2] Print product by code");
            System.out.println("[3] Print tickets");
            System.out.println("[4] Print ticket by id");
            System.out.println("[5] Exit");
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice < 1 || choice > 5)
                System.out.println("Option does not exist.");
            else
                switch(choice){
                    case 1: {
                        System.out.println();
                        printProductsStock();
                    }
                    break;
                    case 2: {
                        int code;
                        System.out.println();
                        System.out.print("Product code: ");
                        code = keyboard.nextInt();
                        keyboard.nextLine();
                        printProductByCode(code);
                    }
                    break;
                    case 3: {
                        System.out.println();
                        printTickets();
                    }
                    break;
                    case 4: {
                        int id;
                        System.out.println();
                        System.out.print("Ticket id: ");
                        id = keyboard.nextInt();
                        keyboard.nextLine();
                        printTicketById(id);
                    }
                    break;
                    case 5: {
                        return;
                    }
                }
        }
    }
}

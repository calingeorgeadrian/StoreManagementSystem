package com.company;

import com.company.services.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String packageTypesFile = "./files/PackageTypes.csv";
        String productCategoriesFile = "./files/ProductCategories.csv";
        String ProductsFile = "./files/Products.csv";
        String ticketsFile =  "./files/Tickets.csv";

        FileService.getInstance().readObjectsFromFile(packageTypesFile, "PackageType");
        FileService.getInstance().readObjectsFromFile(productCategoriesFile, "ProductCategory");
        FileService.getInstance().readObjectsFromFile(ProductsFile, "Product");
        FileService.getInstance().readObjectsFromFile(ticketsFile, "Ticket");

        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("MENU");
            System.out.println("[1] Shop service");
            System.out.println("[2] User service");
            System.out.println("[3] Exit");
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice < 1 || choice > 3)
                System.out.println("Option does not exist.");
            else
                switch(choice){
                    case 1: {
                        ShopService.getInstance().printMenu();
                    }
                    break;
                    case 2: {
                        UserService.getInstance().printMenu();
                    }
                    break;
                    case 3: {
                        return;
                    }
                }
        }
    }
}

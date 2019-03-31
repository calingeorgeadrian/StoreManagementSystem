package com.company.services;

import com.company.models.Provider;

import java.util.Scanner;

public class ProviderService {
    private static ProviderService myInstance = new ProviderService();

    public static ProviderService getInstance() {
        return myInstance;
    }

    private ProviderService() {
    }

    public static void printProviderInfo(Provider provider) {
        provider.printInfo();
    }

    public static void printProviderOrders(Provider provider) {
        provider.printOrders();
    }

    public static void printProviderOrderById(Provider provider, int id) {
        provider.printOrderById(id);
    }

    public static void printProviderOrdersValue(Provider provider) {
        provider.printOrdersValue();
    }

    public static void printMenu(Provider provider) {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("\nMENU");
            System.out.println("[1] Print information");
            System.out.println("[2] Print orders");
            System.out.println("[3] Print order by id");
            System.out.println("[4] Print orders value");
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
                        printProviderInfo(provider);
                    }
                    break;
                    case 2: {
                        System.out.println();
                        printProviderOrders(provider);
                    }
                    break;
                    case 3: {
                        int id;
                        System.out.println();
                        System.out.print("Order id: ");
                        id = keyboard.nextInt();
                        keyboard.nextLine();
                        printProviderOrderById(provider, id);
                    }
                    break;
                    case 4: {
                        printProviderOrdersValue(provider);
                    }
                    break;
                    case 5: {
                        return;
                    }
                }
        }
    }
}

package com.company.services;

import com.company.models.Provider;

import java.util.Date;
import java.util.Scanner;

public class ProviderService {
    private static ProviderService myInstance = new ProviderService();

    public static ProviderService getInstance() {
        return myInstance;
    }

    private ProviderService() {
    }

    public  void printProviderInfo(Provider provider) {
        provider.printInfo();
    }

    public  void printProviderOrders(Provider provider) {
        provider.printOrders();
    }

    public  void printProviderOrderById(Provider provider, int id) {
        provider.printOrderById(id);
    }

    public  void printProviderOrdersValue(Provider provider) {
        provider.printOrdersValue();
    }

    public void changeRegistrationId(Provider provider, int id) { provider.setRegistrationId(id);}

    public  void printMenu(Provider provider) {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("\nMENU");
            System.out.println("[1] Print information");
            System.out.println("[2] Change registration Id");
            System.out.println("[3] Print orders");
            System.out.println("[4] Print order by id");
            System.out.println("[5] Print orders value");
            System.out.println("[6] Exit");
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice < 1 || choice > 6)
                System.out.println("Option does not exist.");
            else
                switch(choice){
                    case 1: {
                        System.out.println();
                        AuditService.getInstance().addActivity("Provider " + provider.getName() + " printed his own information.", new Date());
                        printProviderInfo(provider);
                    }
                    break;
                    case 2: {
                        int id;
                        System.out.print("New registration id: ");
                        id = keyboard.nextInt();
                        System.out.println();
                        changeRegistrationId(provider,id);
                        AuditService.getInstance().addActivity("Cashier " + provider.getName() + " changed his registration id.", new Date());
                        DbService.getInstance().updateProviderRegistrationId(provider.getUsername(), id);
                    }
                    break;
                    case 3: {
                        System.out.println();
                        AuditService.getInstance().addActivity("Provider " + provider.getName() + " printed his orders.", new Date());
                        printProviderOrders(provider);
                    }
                    break;
                    case 4: {
                        int id;
                        System.out.println();
                        System.out.print("Order id: ");
                        id = keyboard.nextInt();
                        keyboard.nextLine();
                        AuditService.getInstance().addActivity("Provider " + provider.getName() + " printed order with id " + id + ".", new Date());
                        printProviderOrderById(provider, id);
                    }
                    break;
                    case 5: {
                        System.out.println();
                        AuditService.getInstance().addActivity("Provider " + provider.getName() + " printed the total value of his orders.", new Date());
                        printProviderOrdersValue(provider);
                    }
                    break;
                    case 6: {
                        return;
                    }
                }
        }
    }
}

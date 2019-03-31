package com.company.services;

import com.company.models.Cashier;

import java.util.Date;
import java.util.Scanner;

public class CashierService {
    private static CashierService myInstance = new CashierService();

    public static CashierService getInstance() {
        return myInstance;
    }

    private CashierService() {
    }

    public static void printCashierInfo(Cashier cashier) {
        cashier.printInfo();
    }

    public static void fireCashier(Cashier cashier) {
        cashier.setEndDate(new Date());
    }

    public static void printMenu(Cashier cashier) {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("\nMENU");
            System.out.println("[1] Print information");
            System.out.println("[2] Fire cashier");
            System.out.println("[3] Exit");
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice < 1 || choice > 3)
                System.out.println("Option does not exist.");
            else
                switch(choice){
                    case 1: {
                        System.out.println();
                        printCashierInfo(cashier);
                    }
                    break;
                    case 2: {
                        System.out.println();
                        fireCashier(cashier);
                    }
                    break;
                    case 3: {
                        return;
                    }
                }
        }
    }
}

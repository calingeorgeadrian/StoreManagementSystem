package com.company.services;

import com.company.models.Cashier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CashierService {
    private static CashierService myInstance = new CashierService();

    public static CashierService getInstance() {
        return myInstance;
    }

    private CashierService() {
    }

    public  void printCashierInfo(Cashier cashier) {
        cashier.printInfo();
    }

    public  void fireCashier(Cashier cashier) {
        cashier.setEndDate(new Date());
    }

    public  void printMenu(Cashier cashier) {
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
                        AuditService.getInstance().addActivity("Cashier " + cashier.getName() + " printed his own information.", new Date());
                        printCashierInfo(cashier);
                    }
                    break;
                    case 2: {
                        System.out.println();
                        AuditService.getInstance().addActivity("Cashier " + cashier.getName() + " has been fired.", new Date());
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        String sqlEndDate = dateFormat.format(new Date());
                        DbService.getInstance().updateCashierById(cashier.getUsername(), sqlEndDate);
                    }
                    break;
                    case 3: {
                        return;
                    }
                }
        }
    }
}

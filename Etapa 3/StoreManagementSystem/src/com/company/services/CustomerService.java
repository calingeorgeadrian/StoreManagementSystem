package com.company.services;

import com.company.models.Address;
import com.company.models.Card;
import com.company.models.Customer;

import java.util.Date;
import java.util.Scanner;

public class CustomerService {
    private static CustomerService myInstance = new CustomerService();

    public static CustomerService getInstance() {
        return myInstance;
    }

    private CustomerService() {
    }

    public  void printCustomerInfo(Customer customer){
        customer.printInfo();
    }

    public  void changeCustomerLocation(Customer customer){
        Scanner keyboard = new Scanner(System.in);
        String country, city, zipCode, address;

        System.out.print("Country: ");
        country = keyboard.nextLine();
        System.out.print("City: ");
        city = keyboard.nextLine();
        System.out.print("ZIP Code: ");
        zipCode = keyboard.nextLine();
        System.out.print("Address: ");
        address = keyboard.nextLine();

        Address location = new Address(country, city, zipCode, address);

        customer.setLocation(location);
        DbService.getInstance().updateCustomerLocation(customer.getUsername(),country,city,zipCode,address);
    }

    public  void changeCustomerShippingInfo(Customer customer){
        Scanner keyboard = new Scanner(System.in);
        String country, city, zipCode, address;

        System.out.print("Country: ");
        country = keyboard.nextLine();
        System.out.print("City: ");
        city = keyboard.nextLine();
        System.out.print("ZIP Code: ");
        zipCode = keyboard.nextLine();
        System.out.print("Address: ");
        address = keyboard.nextLine();

        Address shippingInfo = new Address(country, city, zipCode, address);

        customer.setShippingInfo(shippingInfo);
        DbService.getInstance().updateCustomerShippingInfo(customer.getUsername(),country,city,zipCode,address);
    }

    public  void changeCustomerCard(Customer customer){
        Scanner keyboard = new Scanner(System.in);
        String cardNumber;
        int expirationDay, expirationMonth, expirationYear;
        int cvc;

        System.out.print("Card number: ");
        cardNumber = keyboard.nextLine();
        System.out.print("CVC: ");
        cvc = keyboard.nextInt();
        keyboard.nextLine();

        Card creditCard = new Card(cardNumber,new Date(), cvc);

        customer.setCreditCard(creditCard);
        DbService.getInstance().updateCustomerCreditCard(customer.getUsername(),cardNumber,cvc);
    }

    public  void printMenu(Customer customer) {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("\nMENU");
            System.out.println("[1] Print information");
            System.out.println("[2] Change location");
            System.out.println("[3] Change shipping info");
            System.out.println("[4] Change credit card");
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
                        AuditService.getInstance().addActivity("Customer " + customer.getName() + " printed his own information.", new Date());
                        printCustomerInfo(customer);
                    }
                    break;
                    case 2: {
                        System.out.println();
                        AuditService.getInstance().addActivity("Customer " + customer.getName() + " changed his location.", new Date());
                        changeCustomerLocation(customer);
                    }
                    break;
                    case 3: {
                        System.out.println();
                        AuditService.getInstance().addActivity("Customer " + customer.getName() + " changed his shipping info.", new Date());
                        changeCustomerShippingInfo(customer);
                    }
                    break;
                    case 4: {
                        System.out.println();
                        AuditService.getInstance().addActivity("Customer " + customer.getName() + " changed his credit card info.", new Date());
                        changeCustomerCard(customer);
                    }
                    break;
                    case 5: {
                        return;
                    }
                }
        }
    }
}

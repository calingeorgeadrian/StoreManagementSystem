package com.company.services;

import com.company.models.*;

import java.util.Date;
import java.util.Scanner;

public class UserService {
    private static UserService myInstance = new UserService();

    public static UserService getInstance() {
        if (myInstance == null)
            myInstance = new UserService();
        return myInstance;
    }

    private static User[] listOfUsers;

    private UserService() {
        listOfUsers = new User[3];
        listOfUsers[0] = new Customer();
        listOfUsers[1] = new Provider();
        listOfUsers[2] = new Cashier();
    }

    public static User getOne(String username) {

        for(User user : listOfUsers) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void printUsers() {
        System.out.println("Username\tType");
        for(User user: listOfUsers)
            System.out.println(user.getUsername() + " " + user.getType());
    }

    public static boolean Login(String username, String password) {
        User user = getOne(username);
        if(user != null && user.getPassword().equals(password))
            return true;
        return false;

    }

    public static void printMenu() {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("MENU");
            System.out.println("[1] Login");
            System.out.println("[2] Print users");
            System.out.println("[3] Exit");
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice < 1 || choice > 3)
                System.out.println("Option does not exist.");
            else
                switch(choice){
                    case 1: {
                        String username;
                        String password;
                        System.out.print("Username: ");
                        username = keyboard.nextLine();
                        System.out.print("Password: ");
                        password = keyboard.nextLine();
                        if(UserService.Login(username, password)){
                            System.out.println("User found.");
                            User user = UserService.getOne(username);
                            if(user != null)
                                switch(user.getType()){
                                case "provider": ProviderService.printMenu((Provider)user);
                                break;
                                case "cashier": CashierService.printMenu((Cashier)user);
                                break;
                                case "customer": CustomerService.printMenu((Customer) user);
                                break;
                            }
                        }
                        else
                            System.out.println("Wrong username or password.");
                    }
                    break;
                    case 2: {
                        UserService.printUsers();
                    }
                    break;
                    case 3: {
                        return;
                    }
                }
        }
    }
}

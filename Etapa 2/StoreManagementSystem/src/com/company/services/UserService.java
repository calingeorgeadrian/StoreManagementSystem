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


    public User getOne(String username) {
        for(User user : listOfUsers) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(int id) {
        for (User user: listOfUsers) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public  void printUsers() {
        System.out.println("Username\tType");
        for(User user: listOfUsers)
            System.out.println(user.getUsername() + " " + user.getType());
    }

    public  boolean Login(String username, String password) {
        User user = getOne(username);
        if(user != null && user.getPassword().equals(password))
            return true;
        return false;

    }

    public User[] getUsers() {
        return listOfUsers;
    }

    public  void printMenu() {
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
                        if(UserService.getInstance().Login(username, password)){
                            System.out.println("User found.");
                            User user = UserService.getInstance().getOne(username);
                            AuditService.getInstance().addActivity(username + " logged in.", new Date());
                            if(user != null)
                                switch(user.getType()){
                                case "provider": ProviderService.getInstance().printMenu((Provider)user);
                                break;
                                case "cashier": CashierService.getInstance().printMenu((Cashier)user);
                                break;
                                case "customer": CustomerService.getInstance().printMenu((Customer) user);
                                break;
                            }
                        }
                        else
                            System.out.println("Wrong username or password.");
                        AuditService.getInstance().addActivity(username + " failed to log in.", new Date());
                    }
                    break;
                    case 2: {
                        printUsers();
                    }
                    break;
                    case 3: {
                        return;
                    }
                }
        }
    }
}

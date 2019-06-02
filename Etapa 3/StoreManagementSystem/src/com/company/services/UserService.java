package com.company.services;

import com.company.models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UserService {
    private static UserService myInstance = new UserService();

    public static UserService getInstance() {
        if (myInstance == null)
            myInstance = new UserService();
        return myInstance;
    }

    private ArrayList<User> listOfUsers = new ArrayList<User>();

    private UserService() {
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

    public void Register() {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("MENU");
            System.out.println("[1] Cashier");
            System.out.println("[2] Customer");
            System.out.println("[3] Provider");
            System.out.println("[4] Exit");
            System.out.print("User type: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice < 1 || choice > 4)
                System.out.println("Option does not exist.");
            else
                switch(choice){
                    case 1: {
                        String username;
                        String password;
                        String name;
                        System.out.print("Username: ");
                        username = keyboard.nextLine();
                        System.out.print("Password: ");
                        password = keyboard.nextLine();
                        System.out.print("Name: ");
                        name = keyboard.nextLine();

                        Date hireDate = new Date();

                        AuditService.getInstance().addActivity("New user: " + username + " of type: Cashier has been added to the database.", new Date());
                        DbService.getInstance().insertCashier(username, password, name, hireDate, null);
                    }
                    break;
                    case 2: {
                        String username;
                        String password;
                        String name;
                        String email;
                        String phone;
                        String country, city, zip, address;
                        String cardNumber;
                        int cvc;
                        System.out.print("Username: ");
                        username = keyboard.nextLine();
                        System.out.print("Password: ");
                        password = keyboard.nextLine();
                        System.out.print("Name: ");
                        name = keyboard.nextLine();
                        System.out.print("Email: ");
                        email = keyboard.nextLine();
                        System.out.print("Phone: ");
                        phone = keyboard.nextLine();
                        System.out.print("Country: ");
                        country = keyboard.nextLine();
                        System.out.print("City: ");
                        city = keyboard.nextLine();
                        System.out.print("ZIP Code: ");
                        zip = keyboard.nextLine();
                        System.out.print("Address: ");
                        address = keyboard.nextLine();
                        System.out.print("Card number: ");
                        cardNumber = keyboard.nextLine();
                        System.out.print("CVC: ");
                        cvc = keyboard.nextInt();

                        AuditService.getInstance().addActivity("New user: " + username + " of type: Customer has been added to the database.", new Date());
                        DbService.getInstance().insertCustomer(username,password,name,email,phone,country,city,zip,address,cardNumber,cvc);
                    }
                    break;
                    case 3: {
                        String username;
                        String password;
                        int registrationId;
                        String name;
                        System.out.print("Username: ");
                        username = keyboard.nextLine();
                        System.out.print("Password: ");
                        password = keyboard.nextLine();
                        System.out.print("Name: ");
                        name = keyboard.nextLine();
                        System.out.print("Registration Id: ");
                        registrationId = keyboard.nextInt();

                        AuditService.getInstance().addActivity("New user: " + username + " of type: Provider has been added to the database.", new Date());
                        DbService.getInstance().insertProvider(username, password, registrationId, name);
                    }
                    break;
                    case 4: {
                        return;
                    }
                }
        }
    }

    public ArrayList<User> getUsers() {
        return listOfUsers;
    }


    public void addUser(User user) {
        listOfUsers.add(user);
    }

    public  void printMenu() {
        Scanner keyboard = new Scanner(System.in);

        while(true){
            int choice;
            System.out.println("MENU");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Print users");
            System.out.println("[4] Remove user");
            System.out.println("[5] Exit");
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice < 1 || choice > 5)
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
                        Register();
                    }
                    break;
                    case 3: {
                        printUsers();
                        AuditService.getInstance().addActivity("User has printed the list of users.", new Date());
                    }
                    break;
                    case 4: {
                        System.out.print("Username: ");
                        String username = keyboard.next();

                        AuditService.getInstance().addActivity("User " + username + "has been removed from the database.", new Date());
                        DbService.getInstance().deleteUserByUsername(username);
                    }
                    break;
                    case 5: {
                        return;
                    }
                }
        }
    }
}

package com.company;

import com.company.services.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
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
                        ShopService.printMenu();
                    }
                    break;
                    case 2: {
                        UserService.printMenu();
                    }
                    break;
                    case 3: {
                        return;
                    }
                }
        }
    }
}

package com.company.services;

import com.company.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileService {
    private static FileService ourInstance = new FileService();

    public static FileService getInstance() {
        return ourInstance;
    }

    private FileService() {
    }

    public void readObjectsFromFile(String fileNamePath, String objectType) {
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileNamePath));

            String line;
            String[] values;

            while(true) {

                line = lineNumberReader.readLine();
                if(line == null) break;
                values = line.split(",");

                if(objectType.equals("PackageType")) createPackageType(values);
                else if(objectType.equals("ProductCategory")) createProductCategory(values);
                else if(objectType.equals("Product")) createProduct(values);
                else if(objectType.equals("Ticket")) createTicket(values);
            }

            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createPackageType(String[] values) {
        PackageType newPackageType = new PackageType(Integer.parseInt(values[0]), values[1], values[2], Double.parseDouble(values[3]), values[4]);
        ShopService.getInstance().addPackageType(newPackageType);
    }

    public void createProductCategory(String[] values) {
        ProductCategory newProductCategory = new ProductCategory(Integer.parseInt(values[0]), values[1], values[2]);
        ShopService.getInstance().addProductCategory(newProductCategory);
    }

    public void createProduct(String[] values) {
        ArrayList<ProductCategory> listOfCategories = ShopService.getInstance().getCategories();
        ArrayList<PackageType> listOfPackages = ShopService.getInstance().getPackages();
        try {
            ProductCategory category = listOfCategories.get(Integer.parseInt(values[2])-1);
            try {
                PackageType packageType = listOfPackages.get(Integer.parseInt(values[3])-1);

                Product newProduct = new Product(Integer.parseInt(values[0]), values[1], category, packageType, Double.parseDouble(values[4]), Integer.parseInt(values[5]));
                ShopService.getInstance().addProduct(newProduct);
            }
            catch(NullPointerException e) {
                System.out.println("Package type with id " + (Integer.parseInt(values[3])-1) + " not found.");
            }
        }
        catch(NullPointerException e) {
            System.out.println("Product category with id " + (Integer.parseInt(values[2])-1) + " not found.");
        }
    }

    public void createTicket(String[] values) {
        ArrayList<Product> listOfProducts = ShopService.getInstance().getProducts();
        int numberOfProducts = Integer.parseInt(values[1]);
        int cashierIndex = Integer.parseInt(values[numberOfProducts*2 + 2]);
        Cashier cashier = (Cashier)UserService.getInstance().getUsers()[cashierIndex];
        Date date = new Date(Integer.parseInt(values[1])*2 + 3,Integer.parseInt(values[1])*2 + 4,Integer.parseInt(values[1])*2 + 5);
        List<ProductEntry> entries = new ArrayList<ProductEntry>();

        for(int i=0; i<numberOfProducts; i++) {
            try {
                Product product = listOfProducts.get(Integer.parseInt(values[2+i*2])-1);
                ProductEntry entry = new ProductEntry(product, Integer.parseInt(values[2+i*2+1]));
                entries.add(entry);
            }
            catch(NullPointerException e) {
                System.out.println("Product with id " + (Integer.parseInt(values[2+i*2])-1) + " not found.");
            }
        }
        Ticket newTicket = new Ticket(Integer.parseInt(values[0]), entries, cashier, date);
        ShopService.getInstance().addTicket(newTicket);
    }
}

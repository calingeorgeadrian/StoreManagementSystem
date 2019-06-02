package com.company.services;

import com.company.models.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DbService {
    private static DbService ourInstance = new DbService();

    private Statement statement;
    private Connection connection;

    public static DbService getInstance() {
        return ourInstance;
    }

    private DbService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms?serverTimezone=UTC",
                    "root", "parola12");
            Statement mystatement = myconnection.createStatement();

            this.statement = mystatement;
            this.connection = myconnection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readPackageTypes() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM packagetypes");

        while (resultSet.next()) {
            PackageType newPackageType = new PackageType(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5));
            ShopService.getInstance().addPackageType(newPackageType);
        }

        //System.out.println("Finished reading package types from database.");
    }

    public void readProductCategories() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM productcategories");

        while (resultSet.next()) {
            ProductCategory newCategory = new ProductCategory(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
            ShopService.getInstance().addProductCategory(newCategory);
        }

       // System.out.println("Finished reading product categories from database.");
    }

    public void readProducts() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM products");

        while (resultSet.next()) {
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM productcategories WHERE id = ?");
            pst.setInt(1,resultSet.getInt(3));
            ResultSet rs2 = pst.executeQuery();
            while(rs2.next()) {
                pst = connection.prepareStatement("SELECT * FROM packagetypes WHERE id = ?");
                pst.setInt(1,resultSet.getInt(4));
                ResultSet rs3 = pst.executeQuery();
                while(rs3.next()) {
                    ProductCategory category = new ProductCategory(rs2.getInt(1),
                            rs2.getString(2),
                            rs2.getString(3));

                    PackageType packageType = new PackageType(rs3.getInt(1),
                            rs3.getString(2),
                            rs3.getString(3),
                            rs3.getDouble(4),
                            rs3.getString(5));

                    Product newProduct = new Product(resultSet.getInt(1),
                            resultSet.getString(2),
                            category, packageType,
                            resultSet.getDouble(4),
                            resultSet.getInt(5));
                    ShopService.getInstance().addProduct(newProduct);
                }
            }
        }

        //System.out.println("Finished reading products from database.");
    }

    public void selectProductById(int id) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(" SELECT * FROM products WHERE id = ?");

        pst.setInt(1, id);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            System.out.println("Id: " + resultSet.getInt(1));
            System.out.println("Name: " + resultSet.getString(2));

            pst = connection.prepareStatement("SELECT * FROM productcategories WHERE id = ?");
            pst.setInt(1,resultSet.getInt(3));
            ResultSet rs2 = pst.executeQuery();
            while(rs2.next()) {
                System.out.println("Product category id: " + rs2.getString(1)
                        + "\nProduct category: " + rs2.getString(2)
                        + "\nCategory description: " + rs2.getString(3));
            }

            pst = connection.prepareStatement("SELECT * FROM packagetypes WHERE id = ?");
            pst.setInt(1,resultSet.getInt(4));
            ResultSet rs3 = pst.executeQuery();
            while(rs3.next()) {
                System.out.println("Product container id: " + rs3.getString(1)
                        + "\nProduct container: " + rs3.getString(2)
                        + "\nContainer description: " + rs3.getString(3)
                        + "\nQuantity: " + rs3.getDouble(4) + rs3.getString(5));
            }

            System.out.println("Price: " + resultSet.getDouble(5));
            System.out.println(("Stock: " + resultSet.getInt(6)));
        }
    }

    public void insertProduct(String name,int category,int packageType,double price,int stock){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ArrayList<Product> products = ShopService.getInstance().getProducts();
            statement.execute("INSERT INTO products(id, name, category, package, price, stock) VALUES (" + (products.get(products.size()-1).getId() + 1)
                    + ", '" + name
                    + "', " + category
                    + ", " + packageType
                    + ", " + price
                    + ", " + stock
                    +")");
            ShopService.getInstance().getProducts().clear();
            readProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Product successfully inserted into database.");
    }

    public void updateProductStockById(int id, int stock){

        String sql = "UPDATE products SET stock=? WHERE id='" + id + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, stock);
            pst.executeUpdate();
            ShopService.getInstance().getProducts().clear();
            readProducts();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Product stock successfully updated.");
    }

    public void deleteProductById(int id){

        String sql = "DELETE FROM products WHERE id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            ShopService.getInstance().getProducts().clear();
            readProducts();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Product successfully removed from database.");
    }

    public void readUsers() throws SQLException {
        readCashiers();
        readCustomers();
        readProviders();
    }

    public void readCashiers() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM cashiers");

        try {
            while (resultSet.next()) {
                Date hireDate = new SimpleDateFormat("yyyy/MM/dd").parse(resultSet.getString(6));
                Date endDate;
                if(!resultSet.getString(7).equals("null"))
                    endDate = new SimpleDateFormat("yyyy/MM/dd").parse(resultSet.getString(7));
                else
                    endDate = null;
                Cashier newCashier = new Cashier(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        hireDate,
                        endDate
                );
                UserService.getInstance().addUser(newCashier);
            }
        }
        catch(ParseException e) {
            e.printStackTrace();
        }

        //System.out.println("Finished reading cashiers from database.");
    }

    public void readCustomers() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM customers");

        try {
            while (resultSet.next()) {
                Date registrationDate = new SimpleDateFormat("yyyy/MM/dd").parse(resultSet.getString(5));
                Date lastActive = new SimpleDateFormat("yyyy/MM/dd").parse(resultSet.getString(6));
                Date cardExpirationDate = new SimpleDateFormat("yyyy/MM/dd").parse(resultSet.getString(19));

                Address location = new Address(
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13));

                Address shippingInfo = new Address(
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17));

                Card card = new Card(
                        resultSet.getString(18),
                        cardExpirationDate,
                        resultSet.getInt(20));

                Customer newCustomer = new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        registrationDate,
                        lastActive,
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        location,
                        shippingInfo,
                        card
                );
                UserService.getInstance().addUser(newCustomer);
            }
        }
        catch(ParseException e) {
            e.printStackTrace();
        }

        //System.out.println("Finished reading customers from database.");
    }

    public void readProviders() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM providers");

        while (resultSet.next()) {
            Provider newProvider = new Provider(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    null
            );
            UserService.getInstance().addUser(newProvider);
        }

        //System.out.println("Finished reading providers from database.");
    }

    public void insertCashier(String username, String password, String name, Date hireDate, Date endDate){
        Statement statement = null;
        String type = "cashier";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String sqlHireDate = dateFormat.format(hireDate);
        try {
            statement = connection.createStatement();
            ArrayList<User> users = UserService.getInstance().getUsers();
            statement.execute("INSERT INTO cashiers(id, username, password, type, name, hire_date, end_date) VALUES (" + (users.get(users.size()-1).getId()+1)
                    + ", '" + username
                    + "', '" + password
                    + "', '" + type
                    + "', '" + name
                    + "', '" + sqlHireDate
                    + "', '" + endDate
                    +"')");
            UserService.getInstance().getUsers().clear();
            readUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Cashier successfully inserted into database.");
    }

    public void insertCustomer(String username, String password, String name, String email, String phone, String country, String city, String zip, String address, String cardNumber, int cvc){
        Statement statement = null;
        String type = "customer";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String sqlRegistrationDate = dateFormat.format(new Date());
        String sqlLastActive = dateFormat.format(new Date());
        String sqlExpirationDate = dateFormat.format(new Date());
        try {
            statement = connection.createStatement();
            ArrayList<User> users = UserService.getInstance().getUsers();
            statement.execute("INSERT INTO customers(id, username, password, type, registration_date, last_active, " +
                    "name, email, phone, loc_country, loc_city, loc_ZIP, loc_address, ship_country, ship_city, ship_ZIP, " +
                    "ship_address, card_number, expiration_date, cvc) VALUES (" +  (users.get(users.size()-1).getId()+1)
                    + ", '" + username
                    + "', '" + password
                    + "', '" + type
                    + "', '" + sqlRegistrationDate
                    + "', '" + sqlLastActive
                    + "', '" + name
                    + "', '" + email
                    + "', '" + phone
                    + "', '" + country
                    + "', '" + city
                    + "', '" + zip
                    + "', '" + address
                    + "', '" + country
                    + "', '" + city
                    + "', '" + zip
                    + "', '" + address
                    + "', '" + cardNumber
                    + "', '" + sqlExpirationDate
                    + "', " + cvc
                    +")");
            UserService.getInstance().getUsers().clear();
            readUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Cashier successfully inserted into database.");
    }

    public void insertProvider(String username, String password,int registrationId, String name){
        Statement statement = null;
        String type = "provider";
        try {
            statement = connection.createStatement();
            ArrayList<User> users = UserService.getInstance().getUsers();
            statement.execute("INSERT INTO providers(id, username, password, type,registrationId, name) VALUES (" + (users.get(users.size()-1).getId()+1)
                    + ", '" + username
                    + "', '" + password
                    + "', '" + type
                    + "', " + registrationId
                    + ", '" + name
                    +"')");
            UserService.getInstance().getUsers().clear();
            readUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Provider successfully inserted into database.");
    }

    public void updateCashierById(String username, String date){

        User user = UserService.getInstance().getOne(username);

        String sql = "UPDATE cashiers SET end_date=? WHERE id='" + user.getId() + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, date);
            pst.executeUpdate();
            UserService.getInstance().getUsers().clear();
            readUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Cashier successfully fired.");
    }

    public void updateCustomerLocation(String username, String country, String city, String zip, String address){

        User user = UserService.getInstance().getOne(username);

        String sql = "UPDATE customers SET loc_country=?, loc_city=?, loc_ZIP=?, loc_address=? WHERE id='" + user.getId() + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, country);
            pst.setString(2, city);
            pst.setString(3, zip);
            pst.setString(4, address);
            pst.executeUpdate();
            UserService.getInstance().getUsers().clear();
            readUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Customer location successfully updated.");
    }

    public void updateCustomerShippingInfo(String username, String country, String city, String zip, String address){

        User user = UserService.getInstance().getOne(username);

        String sql = "UPDATE customers SET ship_country=?, ship_city=?, ship_ZIP=?, ship_address=? WHERE id='" + user.getId() + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, country);
            pst.setString(2, city);
            pst.setString(3, zip);
            pst.setString(4, address);
            pst.executeUpdate();
            UserService.getInstance().getUsers().clear();
            readUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Customer shipping info successfully updated.");
    }

    public void updateCustomerCreditCard(String username, String cardNumber, int cvc){

        User user = UserService.getInstance().getOne(username);

        String sql = "UPDATE customers SET card_number=?, cvc=? WHERE id='" + user.getId() + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, cardNumber);
            pst.setInt(2, cvc);
            pst.executeUpdate();
            UserService.getInstance().getUsers().clear();
            readUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Customer credit card successfully updated.");
    }

    public void updateProviderRegistrationId(String username, int id){

        User user = UserService.getInstance().getOne(username);

        String sql = "UPDATE providers SET registrationId=? WHERE id='" + user.getId() + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            UserService.getInstance().getUsers().clear();
            readUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Provider registration id successfully updated.");
    }

    public void deleteUserByUsername(String username){

        User user = UserService.getInstance().getOne(username);
        String tabel = user.getType() + "s";

        String sql = "DELETE FROM " + tabel + " WHERE id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, user.getId());
            pst.executeUpdate();
            UserService.getInstance().getUsers().clear();
            readUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User successfully removed from database.");
    }

}



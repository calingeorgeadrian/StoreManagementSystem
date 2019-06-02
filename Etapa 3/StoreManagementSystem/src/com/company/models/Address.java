package com.company.models;

public class Address {
    private String country = "RO";
    private String city;
    private String zipCode;
    private String address;

    public Address(String country, String city, String zipCode, String home) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.address = home;
    }

    public Address() {
        this.country = "";
        this.city = "";
        this.zipCode = "";
        this.address = "";
    }

    public void printInfo() {
        System.out.println("Country: " + this.country);
        System.out.println("City: " + this.city);
        System.out.println("ZIP Code: " + this.zipCode);
        System.out.println("Address: " + this.address);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHome() {
        return address;
    }

    public void setHome(String home) {
        this.address = home;
    }
}

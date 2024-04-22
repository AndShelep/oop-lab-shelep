package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    protected float price;
    protected float deliveryPrice = 70.0f;
    protected String address;
    protected float cashback;
    private Client client;
    protected ArrayList<Device> devices = new ArrayList<>();

    protected Order(String address, int price, float cashback, float weight, List<Device> cart, Client client){
        this.client = client;
        this.address = address;
        for(var device : cart){
            devices.add(device);
        }
        this.price = price;
        this.deliveryPrice += weight*100;
        this.cashback = cashback;
    }

    protected Order(String address, float price, float cashback, float weight, Device device, Client client){
        this.client = client;
        this.address = address;
        devices.add(device);
        this.price = price;
        this.deliveryPrice += weight*100;
        this.cashback = cashback;
    }

    protected void showDetails(){
        System.out.println("You ordered: ");
        for(var device : devices){
            device.mainDescription();
        }
        System.out.println("Price: " + price + " UAH");
        System.out.println("Price of the delivery: " + deliveryPrice + " UAH");
        System.out.println("Price with delivery: " + (price+deliveryPrice) + " UAH");
        System.out.println("Cashback: " + String.format("%.2f", cashback) + " UAH");
        System.out.println("The package is headed to " + address);
        System.out.println("Recipient: " + client.name + " " + client.surname);
        System.out.println("Phone number: " + client.number);
        System.out.println("Email: " + client.email);
    }
}

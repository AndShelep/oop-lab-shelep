package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Shop shop = new Shop("Capybara");
        Client client1 = new Client("Andrew", "Shelep", "+380000000000", "andriy@lpnu.ua");

        Phone phone1 = new Phone("apple", "iphone 11", 15000f, 8, 8, 3000, 0.3f, 24, 12);
        shop.addDeviceToCatalog(phone1);
        shop.addToHashTable(phone1);
        Phone phone2 = new Phone("apple", "iphone 15 pro max", 60000f, 8, 8, 4000, 0.3f, 50, 24);
        shop.addDeviceToCatalog(phone2);
        shop.addToHashTable(phone2);
        Tablet tablet1 = new Tablet("Samsung", "Galaxy tab", 8000, 8, 10, 3500, 0.4f);
        shop.addDeviceToCatalog(tablet1);
        shop.addToHashTable(tablet1);
        Device tablet2 = new Tablet("Lenovo" ,"Tab M10", 7000, 4, 10.1f, 4500, 0.3f);
        shop.addDeviceToCatalog(tablet2);
        shop.addToHashTable(tablet2);
        Phone phone3 = new Phone("apple", "iphone 15", 45000, 8, 7, 3800, 0.3f, 50, 24);
        shop.addDeviceToCatalog(phone3);
        shop.addToHashTable(phone3);
        Phone phone4 = new Phone("oppo", "klas", 45000, 8, 7, 3800, 0.3f, 50, 24);
        shop.addDeviceToCatalog(phone4);
        shop.addToHashTable(phone4);
        Tablet tablet3 = new Tablet("1" ,"9", 7000, 4, 10.1f, 4500, 0.3f);
        shop.addDeviceToCatalog(tablet3);
        shop.addToHashTable(tablet3);

        /*shop.showDevices();

        phone1.description();
        phone1.chooseMemory(1024);
        phone1.chooseMemory(512);
        phone1.description();

        tablet2.description();

        phone2.changeColor("green");

        float cashbackT1 = tablet1.getCashback();
        System.out.println("Cashback for " + tablet1.trademark + " " + tablet1.model + ": " + cashbackT1 + " UAH");*/

        shop.buy(client1);
        shop.buy(client1, tablet2);

        shop.addToShoppingCart(client1, phone1);
        shop.addToShoppingCart(client1, phone1);
        shop.addToShoppingCart(client1, phone2);
        shop.addToShoppingCart(client1, tablet1);

        shop.removeFromCart(client1);

        shop.showShoppingCart(client1);

        shop.buy(client1);

        shop.showOrders(client1);

        /*Client client2 = new Client("Alex", "Slobozh", "+380111111111", "slobozh@gmail.com");
        shop.buy(client2, tablet1);
        shop.showOrders(client2);

        shop.addToShoppingCart(client2, phone1);
        shop.addToShoppingCart(client2, phone2);

        shop.removeFromCart(client2);
        shop.showShoppingCart(client2);*/

        shop.showOrders();

        shop.getSizeOfTable();
        shop.findItem("apple", "iphone 11");
        shop.findItem("Samsung", "Galaxy tab");
        shop.findItem("apple", "iphone 8");
        shop.removeFromHashTable(phone1);
        shop.findItem("apple", "iphone 11");
    }
}
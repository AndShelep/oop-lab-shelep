package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public String name;
    protected ArrayList<Device> devices = new ArrayList<>();

    public Shop(String name){
        System.out.println("come as you are, as you are\n");
        this.name = name;
    }

    public void addDeviceToCatalog(Device device){
        devices.add(device);
    }

    public void showDevices(){
        System.out.println("Choose the type of devices you want to see: \n1. Phones\n2. Tablets");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if(choice == 1){
            int number = 1;
            for(var device : devices){
                if(device instanceof Phone){
                    System.out.println(number + ".");
                    device.mainDescription();
                    number++;
                }
            }
        } else if (choice == 2){
            int number = 1;
            for(var device : devices){
                if(device instanceof Tablet){
                    System.out.println(number + ".");
                    device.mainDescription();
                    number++;
                }
            }
        } else {
            System.out.println("error\n");
        }
    }

    public void addToShoppingCart(Client client, Device gadget){
        if(client.cart.contains(gadget)){
            System.out.println("You have already added this item to your cart\n");
        } else {
            client.cart.add(gadget);
            System.out.println("the item has been added to the cart\n");
        }
    }

    public void showShoppingCart(Client client){
        System.out.println("Your shopping cart:\n");
        if(client.cart.isEmpty()){
            System.out.println("empty\n");
        } else {
            int i = 1;
            for(Device gadget : client.cart){
                System.out.println(i + ". ");
                gadget.mainDescription();
                i++;
            }
        }
    }

    public void removeFromCart(Client client){
        showShoppingCart(client);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of device you want to remove from shopping cart: ");
        int choice = scan.nextInt();
        if(choice <= 0 || choice > client.cart.size()){
            System.out.println("error\n");
        } else {
            System.out.println("You removed:");
            client.cart.get(choice-1).mainDescription();
            client.cart.remove(choice-1);
        }
    }

    public void buy(Client client, Device gadget){
        Scanner scan = new Scanner(System.in);
        String address;
        System.out.print("enter your address: ");
        address = scan.nextLine();
        Order order = new Order(address, gadget.price, gadget.getCashback(), gadget.weight, gadget);
        client.orders.add(order);
        System.out.println("Your order has been placed\n");
    }

    public void buy(Client client){
        if(client.cart.isEmpty()){
            System.out.println("Your cart is empty");
        } else {
            Scanner scan = new Scanner(System.in);
            String address;
            System.out.print("enter your address: ");
            address = scan.nextLine();
            int price = CountTotalPrice(client);
            float cashback = CountCashback(client);
            float weight = CountWeight(client);
            Order order = new Order(address, price, cashback, weight, client.cart);
            client.orders.add(order);
            System.out.println("Your order has been placed\n");
            client.cart.clear();
        }
    }

    public void showOrders(Client client){
        for(int i = 0; i < client.orders.size(); i++){
            System.out.println("\nOrder №" + (i+1));
            client.orders.get(i).showDetails(client);
        }
    }

    private float CountCashback(Client client){
        float cashback = 0.0f;
        for(var device : client.cart){
            cashback += device.getCashback();
        }
        return  cashback;
    }

    private int CountTotalPrice(Client client){
        int totalPrice = 0;
        for(var device : client.cart){
            totalPrice += device.price;
        }
        return totalPrice;
    }

    private float CountWeight(Client client){
        float weight = 0.0f;
        for(var device : client.cart){
            weight += device.weight;
        }
        return weight;
    }
}

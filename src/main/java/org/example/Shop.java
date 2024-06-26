package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public String name;
    protected ArrayList<Device> devices = new ArrayList<>();
    protected HashTable table = new HashTable();
    protected List orders = new List();
    Scanner scan = new Scanner(System.in);

    public void addToHashTable(Device device){
        table.put(device);
    }
    public void getSizeOfTable(){
        System.out.println("size" + table.size);
    }

    public void findItem(String trademark, String model){
        table.get(trademark, model);
    }

    public void removeFromHashTable(Device device){
        table.remove(device);
    }

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
        if(client.cart.cart.contains(gadget)){
            System.out.println("You have already added this item to your cart\n");
        } else {
            client.cart.addToCart(gadget);
            System.out.println("the item has been added to the cart\n");
        }
    }

    public void showShoppingCart(Client client){
        System.out.println("Your shopping cart:\n");
        if(client.cart.cart.isEmpty()){
            System.out.println("empty\n");
        } else {
            int i = 1;
            for(Device gadget : client.cart.cart){
                System.out.println(i + ". ");
                gadget.mainDescription();
                i++;
            }
        }
    }

    public void removeFromCart(Client client){
        showShoppingCart(client);
        System.out.println("Enter the number of device you want to remove from shopping cart: ");
        int choice = scan.nextInt();
        if(choice <= 0 || choice > client.cart.cart.size()){
            System.out.println("error\n");
        } else {
            System.out.println("You removed:");
            client.cart.cart.get(choice-1).mainDescription();
            client.cart.removeFromCart(choice-1);
        }
    }

    public void buy(Client client, Device gadget){
        String address;
        System.out.print("enter your address: ");
        address = scan.nextLine();
        Order order = new Order(address, gadget.price, gadget.getCashback(), gadget.weight, gadget, client);
        orders.push(order);
        client.orders.add(order);
        System.out.println("Your order has been placed\n");
    }

    public void showOrders(Client client){
        for(int i = 0; i < client.orders.size(); i++){
            System.out.println("\nOrder №" + (i+1));
            client.orders.get(i).showDetails();
        }
    }

    public void showOrders(){
        orders.showList();
    }

    public void buy(Client client){
        if(client.cart.cart.isEmpty()){
            System.out.println("Your cart is empty");
        } else {
            String address;
            System.out.print("enter your address: ");
            address = scan.nextLine();
            float price = CountTotalPrice(client);
            float cashback = CountCashback(client);
            float weight = CountWeight(client);
            Order order = new Order(address, price, cashback, weight, client.cart.cart, client);
            orders.push(order);
            client.orders.add(order);
            System.out.println("Your order has been placed\n");
            client.cart.cart.clear();
        }
    }

    private float CountCashback(Client client){
        float cashback = 0.0f;
        for(var device : client.cart.cart){
            cashback += device.getCashback();
        }
        return  cashback;
    }

    private float CountTotalPrice(Client client){
        float totalPrice = 0;
        for(var device : client.cart.cart){
            totalPrice += device.price;
        }
        return totalPrice;
    }

    private float CountWeight(Client client){
        float weight = 0.0f;
        for(var device : client.cart.cart){
            weight += device.weight;
        }
        return weight;
    }
}

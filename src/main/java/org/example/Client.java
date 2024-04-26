package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    protected String name;
    protected String surname;
    protected String number;
    protected String email;
    protected ShoppingCart cart;
    protected ArrayList<Order> orders = new ArrayList<>();
    public Client(String name, String surname, String number, String email){
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
        cart = new ShoppingCart();
    }

}

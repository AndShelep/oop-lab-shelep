package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Device implements ITechnology {
    protected String trademark;
    protected String model;
    protected int price;
    public String color;
    protected float weight;
    private ArrayList<String> colors = new ArrayList<>();

    public Device(String trademark, String model, int price, float weight){
        this.trademark = trademark;
        this.model = model;
        this.price = price;
        this.color = "black";
        this.weight = weight;
        colors.add("black");
    }

    @Override
    public void setColors() {
        System.out.println("Enter the count of colors for device " + trademark + " " + model);
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        for(int i = 0; i < count; i++){
            String color = scan.nextLine();
            if(colors.contains(color)){
                System.out.println("This color has already been added");
            } else {
                colors.add(color);
            }
        }
    }

    @Override
    public void changeColor(String color) {
        if(colors.contains(color)){
            this.color = color;
        } else {
            System.out.println("There is no such color for this device\n");
        }
    }

    public float getCashback(){
        return price*0.001f;
    }

    public abstract void description();

    @Override
    public void mainDescription(){
        System.out.println(trademark + " " + model + "\ncolor: " + color + "\nprice: " + price + " UAH\n");
    }
}

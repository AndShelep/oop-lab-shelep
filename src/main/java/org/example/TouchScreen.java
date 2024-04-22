package org.example;

public abstract class TouchScreen extends Device{
    private float diagonal;
    private int battery;
    private int ram;
    private int memory;
    private final int[] memories = {64, 128, 256, 512};

    public TouchScreen(String trademark, String model, float price, int ram, float diagonal, int battery, float weight) {
        super(trademark, model, price, weight);
        this.diagonal = diagonal;
        this.battery = battery;
        this.memory = 64;
        this.ram = ram;
    }

    @Override
    public void description() {
        System.out.println(trademark + " " + model + "\ncolor: " + color + "\nprice: " + price + " UAH" + "\nweight: " + weight + "kg");
        System.out.println("memory: " + memory + " gb\nRAM: " + ram + " gb\ndisplay diagonal: " + diagonal + "\"\nbattery: " + battery + " mAh");
    }

    public void chooseMemory(int mem){
        boolean isPresent = false;
        for(int i = 0; i < memories.length; i++){
            if(mem == memories[i]){
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
            System.out.println("there is no phone with " + mem + " gb of memory");
        } else {
            if(mem > memory){
                price = price + mem*1000/memory;
            } else {
                price = price - memory*1000/mem;
            }
            memory = mem;
        }
    }
}

package org.example;

public class Phone extends TouchScreen {
    private int mainCamera;
    private int frontCamera;

    public Phone(String trademark, String model, int price, int ram, float diagonal, int battery, float weight, int mainCamera, int frontCamera) {
        super(trademark, model, price, ram, diagonal, battery, weight);
        this.mainCamera = mainCamera;
        this.frontCamera = frontCamera;
    }

    @Override
    public void description() {
        super.description();
        System.out.println("main camera: " + mainCamera + " MP\nfront camera: " + frontCamera + " MP\n");
    }
}

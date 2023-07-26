package activities;

import java.sql.SQLOutput;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public  Car(){
        tyres=4;
        doors=4;

    }
    public void displayCharacteristics(String color, String transmission, int make, int tyres, int doors ){
        System.out.println(this.color=color);
        System.out.println(this.transmission=transmission);
        System.out.println(this.make= make);
        System.out.println(this.tyres=tyres);
        System.out.println(this.doors=doors);
    }

    public  void  accelerate(){
        System.out.println("Car is moving");
    }
    public void brake(){
        System.out.println("Car has stopped");
    }
}


package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car carName=new Car();
        carName.displayCharacteristics("Black", "Manual", 2014, carName.tyres, carName.doors);
        carName.accelerate();
        carName.brake();
    }
}

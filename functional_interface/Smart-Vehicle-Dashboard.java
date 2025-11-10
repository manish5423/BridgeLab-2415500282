interface Vehicle {
    void displaySpeed();
    default void displayBatteryPercentage(){ }
}
class PetrolVehicle implements Vehicle {
    private String name;
    private int speed;
    PetrolVehicle(String name, int speed){ this.name = name; this.speed = speed; }
    public void displaySpeed(){ System.out.println(name + " speed: " + speed + " km/h"); }
}
class ElectricVehicle implements Vehicle {
    private String name;
    private int speed;
    private int battery;
    ElectricVehicle(String name, int speed, int battery){ this.name = name; this.speed = speed; this.battery = battery; }
    public void displaySpeed(){ System.out.println(name + " speed: " + speed + " km/h"); }
    public void displayBatteryPercentage(){ System.out.println(name + " battery: " + battery + "%"); }
}
public class VehicleDashboardDemo {
    public static void main(String[] args){
        Vehicle petrol = new PetrolVehicle("Sedan", 80);
        Vehicle ev = new ElectricVehicle("E-Zoom", 100, 78);
        petrol.displaySpeed();
        ev.displaySpeed();
        ev.displayBatteryPercentage();
    }
}

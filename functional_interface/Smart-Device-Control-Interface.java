interface SmartDevice {
    void turnOn();
    void turnOff();
}
class Light implements SmartDevice {
    private String name;
    Light(String name){ this.name = name; }
    public void turnOn(){ System.out.println(name + " light switched on"); }
    public void turnOff(){ System.out.println(name + " light switched off"); }
}
class AC implements SmartDevice {
    private String model;
    AC(String model){ this.model = model; }
    public void turnOn(){ System.out.println("AC " + model + " started cooling"); }
    public void turnOff(){ System.out.println("AC " + model + " turned off"); }
}
class TV implements SmartDevice {
    private String brand;
    TV(String brand){ this.brand = brand; }
    public void turnOn(){ System.out.println(brand + " TV is now on"); }
    public void turnOff(){ System.out.println(brand + " TV is now off"); }
}
public class SmartDeviceControl {
    public static void main(String[] args){
        SmartDevice hallLight = new Light("Hall");
        SmartDevice bedroomAC = new AC("CoolAir 3000");
        SmartDevice livingTV = new TV("ViewMax");
        hallLight.turnOn();
        bedroomAC.turnOn();
        livingTV.turnOn();
        hallLight.turnOff();
        bedroomAC.turnOff();
        livingTV.turnOff();
    }
}

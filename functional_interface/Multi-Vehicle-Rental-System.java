interface Rentable {
    void rent(String renterName);
    void returnVehicle();
}
class Car implements Rentable {
    private String plate;
    private boolean rented;
    Car(String plate){ this.plate = plate; }
    public void rent(String renterName){
        rented = true;
        System.out.println("Car " + plate + " rented to " + renterName);
    }
    public void returnVehicle(){
        rented = false;
        System.out.println("Car " + plate + " returned");
    }
}
class Bike implements Rentable {
    private String id;
    private boolean rented;
    Bike(String id){ this.id = id; }
    public void rent(String renterName){
        rented = true;
        System.out.println("Bike " + id + " rented to " + renterName);
    }
    public void returnVehicle(){
        rented = false;
        System.out.println("Bike " + id + " returned");
    }
}
class Bus implements Rentable {
    private String route;
    private boolean rented;
    Bus(String route){ this.route = route; }
    public void rent(String renterName){
        rented = true;
        System.out.println("Bus on " + route + " chartered by " + renterName);
    }
    public void returnVehicle(){
        rented = false;
        System.out.println("Bus on " + route + " is back in depot");
    }
}
public class MultiVehicleRental {
    public static void main(String[] args){
        Rentable car = new Car("MH12AB1234");
        Rentable bike = new Bike("B-07");
        Rentable bus = new Bus("City Express");
        car.rent("Asha");
        bike.rent("Ravi");
        bus.rent("Sun Travels");
        car.returnVehicle();
        bike.returnVehicle();
        bus.returnVehicle();
    }
}

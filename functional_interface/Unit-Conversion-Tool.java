interface UnitConverter {
    static double kmToMiles(double km){ return km * 0.621371; }
    static double milesToKm(double miles){ return miles / 0.621371; }
    static double kgToLbs(double kg){ return kg * 2.20462; }
    static double lbsToKg(double lbs){ return lbs / 2.20462; }
}
public class UnitConversionDemo {
    public static void main(String[] args){
        double km = 10;
        double kg = 5;
        System.out.println(km + " km = " + UnitConverter.kmToMiles(km) + " miles");
        System.out.println(5 + " miles = " + UnitConverter.milesToKm(5) + " km");
        System.out.println(kg + " kg = " + UnitConverter.kgToLbs(kg) + " lbs");
        System.out.println(11 + " lbs = " + UnitConverter.lbsToKg(11) + " kg");
    }
}

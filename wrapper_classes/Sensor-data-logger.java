import java.util.*;
public class SensorDataLogger {
    public static void logPrimitive(double value){
        ArrayList<Double> store = new ArrayList<>();
        store.add(value);
        System.out.println("Logged primitive as wrapper: " + store.get(0));
    }
    public static void logWrapper(Double value){
        double v = (value == null) ? Double.NaN : value;
        System.out.println("Read wrapper as primitive: " + v);
    }
    public static void main(String[] args){
        logPrimitive(23.5);
        logWrapper(Double.valueOf(26.7));
        logWrapper(null);
    }
}


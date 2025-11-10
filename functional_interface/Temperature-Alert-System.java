import java.util.function.Predicate;
public class TemperatureAlert {
    public static void main(String[] args){
        Predicate<Double> exceedsThreshold = temp -> temp > 37.5;
        double[] readings = {36.7, 37.6, 38.2, 36.4};
        for(double reading : readings){
            if(exceedsThreshold.test(reading)){
                System.out.println("ALERT: temperature " + reading + " exceeds threshold");
            } else {
                System.out.println("OK: temperature " + reading);
            }
        }
    }
}

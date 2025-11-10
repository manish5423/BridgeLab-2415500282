import java.util.*;
import java.util.function.Predicate;
public class NotificationFilter {
    public static void main(String[] args){
        List<String> alerts = Arrays.asList("Cardiac", "Normal", "Critical", "Routine", "Emergency");
        Predicate<String> filter = a -> a.equals("Critical") || a.equals("Emergency") || a.equals("Cardiac");
        alerts.stream().filter(filter).forEach(System.out::println);
    }
}

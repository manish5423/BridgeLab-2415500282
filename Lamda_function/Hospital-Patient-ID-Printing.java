import java.util.*;
public class PatientIdPrinter {
    public static void main(String[] args){
        List<String> ids = Arrays.asList("P101","P202","P303","P404");
        ids.forEach(System.out::println);
    }
}

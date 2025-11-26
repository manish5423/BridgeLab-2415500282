import java.util.*;

public class SubSetCheck {
    public static void main(String[] args) {
        Set<Integer> small = new HashSet<>(Arrays.asList(2,3));
        Set<Integer> big = new HashSet<>(Arrays.asList(1,2,3,4));

        System.out.println(big.containsAll(small));
    }
}

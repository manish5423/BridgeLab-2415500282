import java.util.*;

public class SetEqual {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> b = new HashSet<>(Arrays.asList(3,2,1));

        System.out.println(a.equals(b));
    }
}

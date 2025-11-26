import java.util.*;

public class SymDiff {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> b = new HashSet<>(Arrays.asList(3,4,5));

        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);

        Set<Integer> common = new HashSet<>(a);
        common.retainAll(b);

        result.removeAll(common);

        System.out.println(result);
    }
}

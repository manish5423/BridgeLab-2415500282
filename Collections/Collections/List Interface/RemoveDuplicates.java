import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,1,2,2,3,4);

        List<Integer> result = new ArrayList<>();

        for (int x : list) {

            boolean found = false;

           
            for (int y : result) {
                if (y == x) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.add(x);
            }
        }

        System.out.println(result);
    }
}

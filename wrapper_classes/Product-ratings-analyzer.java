import java.util.*;
import java.util.stream.*;
public class ProductRatingsAnalyzer {
    public static void main(String[] args){
        int[] oldRatings = {5,4,3,5};
        ArrayList<Integer> newRatings = new ArrayList<>(Arrays.asList(4, null, 5, 2));
        ArrayList<Integer> combined = new ArrayList<>();
        for(int r : oldRatings) combined.add(r);
        for(Integer r : newRatings) combined.add(r);
        List<Integer> valid = combined.stream().filter(Objects::nonNull).collect(Collectors.toList());
        double avg = valid.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Average rating = " + avg);
    }
}


import java.util.*;
public class WrapperObjectsInCollections {
    public static void main(String[] args){
        double[] prices = {10.5, 20.0, 35.75, 5.5};
        ArrayList<Double> list = new ArrayList<>();
        for(double p : prices) list.add(p);
        double max = Collections.max(list);
        double sum = 0;
        for(Double d : list) sum += d;
        double avg = sum / list.size();
        System.out.println("Highest price = " + max);
        System.out.println("Average price = " + avg);
    }
}


import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("A",10); map.put("B",20); map.put("C",15);

        String maxKey = "";
        int maxVal = Integer.MIN_VALUE;

        for(String k : map.keySet()){
            if(map.get(k) > maxVal){
                maxVal = map.get(k);
                maxKey = k;
            }
        }

        System.out.println(maxKey);
    }
}

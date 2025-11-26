import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("A",1); map.put("B",2); map.put("C",1);

        Map<Integer,List<String>> inv = new HashMap<>();

        for(String key : map.keySet()){
            int v = map.get(key);
            inv.putIfAbsent(v, new ArrayList<>());
            inv.get(v).add(key);
        }

        System.out.println(inv);
    }
}

import java.util.*;

public class WordFreq {
    public static void main(String[] args) {
        String text = "Hello world hello Java";
        Map<String,Integer> map = new HashMap<>();

        String[] words = text.toLowerCase().split(" ");

        for(String w : words){
            if(map.containsKey(w))
                map.put(w, map.get(w)+1);
            else
                map.put(w,1);
        }

        System.out.println(map);
    }
}

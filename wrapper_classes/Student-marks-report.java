import java.util.*;
public class StudentMarksReport {
    public static void main(String[] args){
        Object[] inputs = {"85", 95, Integer.valueOf(88), "null", "abc", 72};
        List<Integer> marks = new ArrayList<>();
        for(Object o : inputs){
            if(o == null) continue;
            if(o instanceof Integer) marks.add((Integer)o);
            else if(o instanceof String){
                String s = ((String)o).trim();
                if("null".equalsIgnoreCase(s)) continue;
                try{ marks.add(Integer.valueOf(s)); } catch(Exception e){}
            }
        }
        double avg = marks.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Valid marks: " + marks);
        System.out.println("Average = " + avg);
    }
}


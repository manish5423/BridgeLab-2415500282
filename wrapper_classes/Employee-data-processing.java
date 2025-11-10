import java.util.*;
public class EmployeeDataProcessing {
    public static void main(String[] args){
        int[] ages = {34, 28, 45, 22, 39};
        ArrayList<Integer> ageList = new ArrayList<>();
        for(int a : ages) ageList.add(a);
        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);
        System.out.println("Youngest age = " + youngest);
        System.out.println("Oldest age = " + oldest);
    }
}


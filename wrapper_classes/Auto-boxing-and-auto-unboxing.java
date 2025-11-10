import java.util.*;
public class AutoboxUnboxDemo {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(10);
        numbers.add(8);
        numbers.add(20);
        numbers.add(12);
        int sum = 0;
        for(Integer n : numbers) sum += n;
        System.out.println("Sum of numbers = " + sum);
    }
}


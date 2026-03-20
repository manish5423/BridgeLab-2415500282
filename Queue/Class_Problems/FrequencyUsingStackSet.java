package com.learn;
import java.util.*;

public class FrequencyUsingStackSet {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int [] arr = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		arr[i]=sc.nextInt();
    	}
    	
        
        

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();

       
        for (int num : arr) {
            stack.push(num);
        }

       
        while (!stack.isEmpty()) {
            int element = stack.pop();

           
            if (!set.contains(element)) {

                int count = 0;

               
                for (int num : arr) {
                    if (num == element) {
                        count++;
                    }
                }

               
                System.out.println("Element: " + element + " Frequency: " + count);

              
                set.add(element);
            }
        }
    }
}
import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
         q.add(20); 
         q.add(30);

        Stack<Integer> st = new Stack<>();

        while(!q.isEmpty())
            st.push(q.remove());

        while(!st.isEmpty())
            q.add(st.pop());

        System.out.println(q);
    }
}

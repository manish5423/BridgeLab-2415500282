import java.util.*;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x){
        q1.add(x);
    }

    int pop(){
        while(q1.size() > 1)
            q2.add(q1.remove());

        int top = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1); st.push(2); st.push(3);
        System.out.println(st.pop());
    }
}

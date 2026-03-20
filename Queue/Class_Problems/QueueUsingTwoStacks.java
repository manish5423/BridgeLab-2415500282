package com.learn;

import java.util.Stack;

public class QueueUsingTwoStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue (O(1))
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue (Amortized O(1))
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Transfer only if needed
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek (Front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Main method
    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.peek());       // 20
        System.out.println("Dequeued: " + q.dequeue()); // 20
    }
}
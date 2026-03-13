package com.linkedlist;

import java.util.Scanner;

class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Function to increase stack size
    private void increaseSize() {
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity];

        for (int i = 0; i < capacity; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        capacity = newCapacity;

        System.out.println("Stack size increased to: " + capacity);
    }

    // Push element
    public void push(int x) {

        if (isFull()) {
            increaseSize();   // automatically increase size
        }

        arr[++top] = x;
        System.out.println("Pushed: " + x);
    }

    // Pop element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }

    // Peek element
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        System.out.println("Stack is empty");
        return -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}

public class Link {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        Stack stack = new Stack(size);

        while (true) {

            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    int element = sc.nextInt();
                    stack.push(element);
                    break;

                case 2:
                    int popped = stack.pop();
                    if (popped != -1)
                        System.out.println("Popped: " + popped);
                    break;

                case 3:
                    System.out.println("Top element: " + stack.peek());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

//why it just shrinking 25% not 50% or any other ?
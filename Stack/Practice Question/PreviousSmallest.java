package com.linkedlist;

import java.util.Stack;

public class PreviousSmallest {

    public static void findPreviousSmallest(int arr[]) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.println(arr[i] + " -> -1");
            } 
            else {
                System.out.println(arr[i] + " -> " + stack.peek());
            }

            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 3, 2, 4};

        findPreviousSmallest(arr);
    }
}
package com.linkedlist;
import java.util.Stack;

public class NextGreaterElement {

    public static void findNextGreater(int arr[]) {

        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int result[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +" " + result[i]);
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 3, 2, 4};

        findNextGreater(arr);
    }
}
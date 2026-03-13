package com.linkedlist;
import java.util.Stack;

public class DeleteConsequitive {

    public static int removeDuplicates(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();     // remove consecutive duplicate
            } 
            else {
                stack.push(ch);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {

        String arr[] = {"abbaca", "azxxzy", "aabbcc"};

        for (String s : arr) {

            int size = removeDuplicates(s);

            System.out.println("String: " + s);
            System.out.println("Size after deletion: " + size);
            System.out.println();
        }
    }
}
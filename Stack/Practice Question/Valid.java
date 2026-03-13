package com.linkedlist;

import java.util.Scanner;

public class Valid {

    // Node class
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    // PUSH operation
    public static void push(char c) {
        Node newNode = new Node(c);
        newNode.next = top;
        top = newNode;
    }

    // POP operation
    public static char pop() {
        if (top == null) {
            return '#';
        }

        char val = top.data;
        top = top.next;
        return val;
    }

    public static boolean isEmpty() {
        return top == null;
    }

    // Check balanced parentheses
    public static boolean isBalanced(String expr) {

        for (int i = 0; i < expr.length(); i++) {

            char ch = expr.charAt(i);

            // opening bracket
            if (ch == '(' || ch == '{' || ch == '[') {
                push(ch);
            }

            // closing bracket
            else if (ch == ')' || ch == '}' || ch == ']') {

                if (isEmpty()) {
                    return false;
                }

                char topChar = pop();

                if ((ch == ')' && topChar != '(') ||
                    (ch == '}' && topChar != '{') ||
                    (ch == ']' && topChar != '[')) {
                    return false;
                }
            }
        }

        return isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expr = sc.nextLine();

        if (isBalanced(expr)) {
            System.out.println("Parentheses are Balanced");
        } 
        else {
            System.out.println("Parentheses are NOT Balanced");
        }

        sc.close();
    }
}
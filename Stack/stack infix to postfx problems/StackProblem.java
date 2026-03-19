package com.linkedlist;

import java.util.Scanner;
import java.util.Stack;

public class StackProblem {

    // Function to return precedence
    static int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }

    // Check right associativity (only for ^)
    static boolean isRightAssociative(char ch) {
        return ch == '^';
    }

    // Main conversion function
    static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // Ignore spaces
            if (ch == ' ') continue;

            // Operand (a-z, A-Z, 0-9)
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop(); // remove '('
            }

            // Operator
            else {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        (precedence(stack.peek()) > precedence(ch) ||
                        (precedence(stack.peek()) == precedence(ch) && !isRightAssociative(ch)))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        //String exp = "a*(b+c)/d";
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        String postfix = infixToPostfix(exp);
        System.out.println("Postfix Expression: " + postfix);
    }
}
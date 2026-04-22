import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem5ExpressionTreeEvaluation {
    static class Node {
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
        }
    }

    static void inorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        inorder(root.left, out);
        out.add(root.value);
        inorder(root.right, out);
    }

    static void preorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        out.add(root.value);
        preorder(root.left, out);
        preorder(root.right, out);
    }

    static void postorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        postorder(root.left, out);
        postorder(root.right, out);
        out.add(root.value);
    }

    static String inorderWithParentheses(Node root) {
        if (root.left == null && root.right == null) {
            return root.value;
        }
        return "(" + inorderWithParentheses(root.left) + " " + root.value + " " + inorderWithParentheses(root.right) + ")";
    }

    static int evaluatePostfix(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(apply(token, a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    static int apply(String op, int a, int b) {
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return a - b;
        }
        if (op.equals("*")) {
            return a * b;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Node multiply = new Node("*");
        multiply.left = new Node("+");
        multiply.right = new Node("-");
        multiply.left.left = new Node("3");
        multiply.left.right = new Node("5");
        multiply.right.left = new Node("8");
        multiply.right.right = new Node("2");

        List<String> in = new ArrayList<>();
        List<String> pre = new ArrayList<>();
        List<String> post = new ArrayList<>();

        inorder(multiply, in);
        preorder(multiply, pre);
        postorder(multiply, post);

        int result = evaluatePostfix(post);

        Node expr = new Node("-");
        expr.left = new Node("+");
        expr.right = new Node("e");
        expr.left.left = new Node("*");
        expr.left.right = new Node("/");
        expr.left.left.left = new Node("a");
        expr.left.left.right = new Node("b");
        expr.left.right.left = new Node("c");
        expr.left.right.right = new Node("d");

        List<String> in2 = new ArrayList<>();
        List<String> pre2 = new ArrayList<>();
        List<String> post2 = new ArrayList<>();

        inorder(expr, in2);
        preorder(expr, pre2);
        postorder(expr, post2);

        System.out.println("Problem 5 Answers");
        System.out.println("a) Postorder for (3 + 5) * (8 - 2): " + post);
        System.out.println("   Postfix form: 3 5 + 8 2 - *");
        System.out.println("b) Inorder with parentheses: " + inorderWithParentheses(multiply));
        System.out.println("c) Preorder for prefix notation: " + pre);
        System.out.println("d) Stack-based postorder evaluation result: " + result);
        System.out.println("e) For a * b + c / d - e interpreted as ((a*b) + (c/d)) - e:");
        System.out.println("   Inorder: " + in2);
        System.out.println("   Inorder with parentheses: " + inorderWithParentheses(expr));
        System.out.println("   Preorder: " + pre2);
        System.out.println("   Postorder: " + post2);
    }
}

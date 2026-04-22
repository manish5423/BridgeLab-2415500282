import java.util.ArrayList;
import java.util.List;

public class Problem4BSTOperations {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static Node insert(Node root, int value, List<String> trace) {
        if (root == null) {
            trace.add("Inserted " + value + " at empty position");
            return new Node(value);
        }
        if (value < root.value) {
            trace.add(value + " < " + root.value + " -> go left");
            root.left = insert(root.left, value, trace);
        } else {
            trace.add(value + " > " + root.value + " -> go right");
            root.right = insert(root.right, value, trace);
        }
        return root;
    }

    static Node delete(Node root, int key, List<String> trace) {
        if (root == null) {
            return null;
        }
        if (key < root.value) {
            trace.add(key + " < " + root.value + " -> go left");
            root.left = delete(root.left, key, trace);
        } else if (key > root.value) {
            trace.add(key + " > " + root.value + " -> go right");
            root.right = delete(root.right, key, trace);
        } else {
            trace.add("Found node " + key);
            if (root.left == null) {
                trace.add("Node has no left child -> replace with right child");
                return root.right;
            }
            if (root.right == null) {
                trace.add("Node has no right child -> replace with left child");
                return root.left;
            }
            Node successor = minNode(root.right);
            trace.add("Node has two children -> inorder successor is " + successor.value);
            root.value = successor.value;
            trace.add("Replace value with successor and delete successor node");
            root.right = delete(root.right, successor.value, trace);
        }
        return root;
    }

    static Node minNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    static void inorder(Node root, List<Integer> out) {
        if (root == null) {
            return;
        }
        inorder(root.left, out);
        out.add(root.value);
        inorder(root.right, out);
    }

    static void rangeQuery(Node root, int low, int high, List<Integer> out) {
        if (root == null) {
            return;
        }
        if (root.value > low) {
            rangeQuery(root.left, low, high, out);
        }
        if (root.value >= low && root.value <= high) {
            out.add(root.value);
        }
        if (root.value < high) {
            rangeQuery(root.right, low, high, out);
        }
    }

    public static void main(String[] args) {
        int[] initial = {15, 10, 20, 8, 12, 17, 25};
        Node root = null;
        for (int value : initial) {
            root = insert(root, value, new ArrayList<>());
        }

        List<String> deleteTrace = new ArrayList<>();
        root = delete(root, 10, deleteTrace);

        List<String> insert14Trace = new ArrayList<>();
        root = insert(root, 14, insert14Trace);

        List<String> insert9Trace = new ArrayList<>();
        root = insert(root, 9, insert9Trace);

        List<Integer> inorderResult = new ArrayList<>();
        inorder(root, inorderResult);

        List<Integer> between10And20 = new ArrayList<>();
        rangeQuery(root, 10, 20, between10And20);

        System.out.println("Problem 4 Answers");
        System.out.println("a) Delete node 10 (two children) steps:");
        for (String step : deleteTrace) {
            System.out.println("   - " + step);
        }

        System.out.println("b) Insert 14 steps:");
        for (String step : insert14Trace) {
            System.out.println("   - " + step);
        }

        System.out.println("c) Insert 9 steps:");
        for (String step : insert9Trace) {
            System.out.println("   - " + step);
        }

        System.out.println("Tree inorder after all operations: " + inorderResult);
        System.out.println("d) Efficient method for range [10, 20]: Inorder-style range query with pruning");
        System.out.println("   Students in range: " + between10And20);
        System.out.println("e) Search complexity for roll 25:");
        System.out.println("   Best-case: O(1)");
        System.out.println("   Worst-case: O(n)");
        System.out.println("   In a balanced BST: O(log n)");
    }
}

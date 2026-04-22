import java.util.ArrayList;
import java.util.List;

public class Problem3BSTConstructionValidation {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    static void inorder(Node root, List<Integer> out) {
        if (root == null) {
            return;
        }
        inorder(root.left, out);
        out.add(root.value);
        inorder(root.right, out);
    }

    static List<Integer> searchComparisons(Node root, int target) {
        List<Integer> compared = new ArrayList<>();
        Node current = root;
        while (current != null) {
            compared.add(current.value);
            if (target == current.value) {
                break;
            } else if (target < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return compared;
    }

    static boolean isValidBst(Node root) {
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isValidBst(Node node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.value <= min || node.value >= max) {
            return false;
        }
        return isValidBst(node.left, min, node.value) && isValidBst(node.right, node.value, max);
    }

    static int heightEdges(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(heightEdges(root.left), heightEdges(root.right));
    }

    static void printTreeShape() {
        System.out.println("a) Resulting BST:");
        System.out.println("          50");
        System.out.println("        /    \\");
        System.out.println("      30      70");
        System.out.println("     /  \\    /  \\");
        System.out.println("   20   40  60   80");
        System.out.println("  /  \\");
        System.out.println("10   25");
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25};
        Node root = null;
        for (int v : values) {
            root = insert(root, v);
        }

        List<Integer> inorderResult = new ArrayList<>();
        inorder(root, inorderResult);

        List<Integer> comparisons = searchComparisons(root, 25);

        Node invalidRoot = new Node(50);
        invalidRoot.left = new Node(30);
        invalidRoot.right = new Node(70);
        invalidRoot.left.left = new Node(20);
        invalidRoot.left.right = new Node(65);
        invalidRoot.right.left = new Node(60);
        invalidRoot.right.right = new Node(80);

        int balancedHeightEdges = heightEdges(root);
        int skewedHeightEdges = values.length - 1;

        System.out.println("Problem 3 Answers");
        printTreeShape();
        System.out.println("b) Search comparisons for 25: " + comparisons);
        System.out.println("c) Inorder traversal: " + inorderResult);
        System.out.println("   Sorted check: " + isSorted(inorderResult));
        System.out.println("d) Is the given tree a valid BST? " + isValidBst(invalidRoot));
        System.out.println("   Reason: Node 65 is in left subtree of 50 but greater than 50.");
        System.out.println("e) Balanced BST height (edges): " + balancedHeightEdges);
        System.out.println("   Skewed BST height with 9 elements (edges): " + skewedHeightEdges);
        System.out.println("   Balanced height (levels): " + (balancedHeightEdges + 1));
        System.out.println("   Skewed height (levels): " + (skewedHeightEdges + 1));
    }

    static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}

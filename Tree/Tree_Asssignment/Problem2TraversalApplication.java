import java.util.ArrayList;
import java.util.List;

public class Problem2TraversalApplication {
    static class Node {
        String name;
        Node left;
        Node right;

        Node(String name) {
            this.name = name;
        }
    }

    static void inorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        inorder(root.left, out);
        out.add(root.name);
        inorder(root.right, out);
    }

    static void preorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        out.add(root.name);
        preorder(root.left, out);
        preorder(root.right, out);
    }

    static void postorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        postorder(root.left, out);
        postorder(root.right, out);
        out.add(root.name);
    }

    public static void main(String[] args) {
        Node root = new Node("root");
        Node home = new Node("home");
        Node var = new Node("var");
        Node user = new Node("user");
        Node docs = new Node("docs");
        Node log = new Node("log");
        Node config = new Node("config");

        root.left = home;
        root.right = var;
        home.left = user;
        home.right = docs;
        user.left = config;
        var.right = log;

        List<String> in = new ArrayList<>();
        List<String> pre = new ArrayList<>();
        List<String> post = new ArrayList<>();

        inorder(root, in);
        preorder(root, pre);
        postorder(root, post);

        System.out.println("Problem 2 Answers");
        System.out.println("a) For alphabetical order in a BST: Inorder traversal");
        System.out.println("b) For directory size aggregation: Postorder traversal");
        System.out.println("c) For backup starting at root: Preorder traversal");
        System.out.println("d) Inorder: " + in);
        System.out.println("   Preorder: " + pre);
        System.out.println("   Postorder: " + post);
        System.out.println("e) Postorder deletion is safe because children are processed before their parent directory.");
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1TreeTerminology {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        Node(String name) {
            this.name = name;
        }

        void addChild(Node child) {
            children.add(child);
        }
    }

    static List<String> getLeafNodes(Node root) {
        List<String> leaves = new ArrayList<>();
        collectLeaves(root, leaves);
        return leaves;
    }

    static void collectLeaves(Node node, List<String> leaves) {
        if (node == null) {
            return;
        }
        if (node.children.isEmpty()) {
            leaves.add(node.name);
            return;
        }
        for (Node child : node.children) {
            collectLeaves(child, leaves);
        }
    }

    static int heightInEdges(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.children.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (Node child : node.children) {
            max = Math.max(max, heightInEdges(child));
        }
        return max + 1;
    }

    static int depth(Node root, String target) {
        return depthDfs(root, target, 0);
    }

    static int depthDfs(Node node, String target, int currentDepth) {
        if (node == null) {
            return -1;
        }
        if (node.name.equals(target)) {
            return currentDepth;
        }
        for (Node child : node.children) {
            int found = depthDfs(child, target, currentDepth + 1);
            if (found != -1) {
                return found;
            }
        }
        return -1;
    }

    static List<String> ancestors(Node root, String target) {
        List<String> path = new ArrayList<>();
        if (!buildPath(root, target, path)) {
            return Collections.emptyList();
        }
        path.remove(path.size() - 1);
        return path;
    }

    static boolean buildPath(Node node, String target, List<String> path) {
        if (node == null) {
            return false;
        }
        path.add(node.name);
        if (node.name.equals(target)) {
            return true;
        }
        for (Node child : node.children) {
            if (buildPath(child, target, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node ceo = new Node("CEO");
        Node cto = new Node("CTO");
        Node cfo = new Node("CFO");
        Node devLead = new Node("Dev Lead");
        Node hr = new Node("HR");
        Node dev1 = new Node("Dev1");
        Node dev2 = new Node("Dev2");

        ceo.addChild(cto);
        ceo.addChild(cfo);
        cto.addChild(devLead);
        cfo.addChild(hr);
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        List<String> leafNodes = getLeafNodes(ceo);
        int heightEdges = heightInEdges(ceo);
        int depthDevLead = depth(ceo, "Dev Lead");
        List<String> ancestorsDev1 = ancestors(ceo, "Dev1");
        int degreeCto = cto.children.size();

        System.out.println("Problem 1 Answers");
        System.out.println("a) Leaf nodes: " + leafNodes);
        System.out.println("b) Height of tree (in edges): " + heightEdges);
        System.out.println("   Height in levels: " + (heightEdges + 1));
        System.out.println("c) Depth of Dev Lead: " + depthDevLead);
        System.out.println("d) Ancestors of Dev1: " + ancestorsDev1);
        System.out.println("e) Degree of CTO: " + degreeCto);
    }
}

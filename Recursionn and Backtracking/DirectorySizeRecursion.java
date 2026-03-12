import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DirectorySizeRecursion {
    static class Node {
        String name;
        boolean isFile;
        int fileSizeKB;
        List<Node> children;

        Node(String name, boolean isFile, int fileSizeKB) {
            this.name = name;
            this.isFile = isFile;
            this.fileSizeKB = fileSizeKB;
            this.children = new ArrayList<>();
        }

        void addChild(Node child) {
            children.add(child);
        }
    }

    public static void main(String[] args) {
        Node project = new Node("project", false, 0);

        Node src = new Node("src", false, 0);
        src.addChild(new Node("main.java", true, 100));
        src.addChild(new Node("utils.java", true, 50));

        Node docs = new Node("docs", false, 0);
        docs.addChild(new Node("readme.txt", true, 10));

        Node guides = new Node("guides", false, 0);
        guides.addChild(new Node("setup.pdf", true, 200));
        docs.addChild(guides);

        project.addChild(src);
        project.addChild(docs);
        project.addChild(new Node("config.xml", true, 20));

        Set<Node> visited = new HashSet<>();
        int totalSize = calculateTotalSize(project, visited);

        System.out.println("Total directory size: " + totalSize + " KB");
    }

    public static int calculateTotalSize(Node current, Set<Node> visited) {
        if (current == null) {
            return 0;
        }

        if (visited.contains(current)) {
            return 0;
        }
        visited.add(current);

        if (current.isFile) {
            return current.fileSizeKB;
        }

        int total = 0;
        for (Node child : current.children) {
            total += calculateTotalSize(child, visited);
        }
        return total;
    }
}

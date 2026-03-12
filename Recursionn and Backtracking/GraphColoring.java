public class GraphColoring {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };

        int minColors = findMinimumColors(graph);
        System.out.println("Minimum colors needed: " + minColors);
    }

    public static int findMinimumColors(int[][] graph) {
        int vertices = graph.length;

        for (int colors = 1; colors <= vertices; colors++) {
            int[] colorAssignment = new int[vertices];

            if (canColor(graph, colors, 0, colorAssignment)) {
                printColoring(colorAssignment);
                return colors;
            }
        }

        return vertices;
    }

    private static boolean canColor(int[][] graph, int maxColors, int vertex, int[] colorAssignment) {
        if (vertex == graph.length) {
            return true;
        }

        for (int color = 1; color <= maxColors; color++) {
            if (isSafe(graph, vertex, color, colorAssignment)) {
                colorAssignment[vertex] = color;

                if (canColor(graph, maxColors, vertex + 1, colorAssignment)) {
                    return true;
                }

                colorAssignment[vertex] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] graph, int vertex, int color, int[] colorAssignment) {
        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (graph[vertex][neighbor] == 1 && colorAssignment[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    private static void printColoring(int[] colorAssignment) {
        System.out.println("One valid coloring:");
        for (int i = 0; i < colorAssignment.length; i++) {
            System.out.println("Vertex " + i + " -> Color " + colorAssignment[i]);
        }
    }
}

import java.util.*;

public class Problem5NetworkPacketRouting {
    private final Map<String, Set<String>> graph = new LinkedHashMap<>();

    public void addRouter(String router) {
        graph.computeIfAbsent(router, key -> new LinkedHashSet<>());
    }

    public void addConnection(String router1, String router2) {
        addRouter(router1);
        addRouter(router2);
        graph.get(router1).add(router2);
        graph.get(router2).add(router1);
    }

    public Map<String, List<Integer>> adjacencyListRepresentation() {
        Map<String, List<Integer>> representation = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            List<Integer> neighbors = new ArrayList<>();
            for (String neighbor : entry.getValue()) {
                neighbors.add(Integer.parseInt(neighbor.substring(1)));
            }
            representation.put(entry.getKey(), neighbors);
        }
        return representation;
    }

    public int[][] adjacencyMatrix(List<String> routers) {
        int size = routers.size();
        int[][] matrix = new int[size][size];
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < size; i++) {
            index.put(routers.get(i), i);
        }
        for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            Integer from = index.get(entry.getKey());
            if (from == null) {
                continue;
            }
            for (String neighbor : entry.getValue()) {
                Integer to = index.get(neighbor);
                if (to != null) {
                    matrix[from][to] = 1;
                }
            }
        }
        return matrix;
    }

    public boolean isConnected() {
        if (graph.isEmpty()) {
            return true;
        }
        String start = graph.keySet().iterator().next();
        return reachableFrom(start).size() == graph.size();
    }

    private Set<String> reachableFrom(String start) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String neighbor : graph.getOrDefault(current, Collections.emptySet())) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    public List<String> alternativePath(String start, String end, String failedA, String failedB) {
        return bfsPath(start, end, failedA, failedB);
    }

    public List<String> minimumHopsPath(String start, String end) {
        return bfsPath(start, end, null, null);
    }

    private List<String> bfsPath(String start, String end, String failedA, String failedB) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return Collections.emptyList();
        }
        Queue<String> queue = new ArrayDeque<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) {
                break;
            }
            for (String neighbor : graph.getOrDefault(current, Collections.emptySet())) {
                if (isFailedEdge(current, neighbor, failedA, failedB)) {
                    continue;
                }
                if (visited.add(neighbor)) {
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        if (!visited.contains(end)) {
            return Collections.emptyList();
        }
        LinkedList<String> path = new LinkedList<>();
        for (String node = end; node != null; node = parent.get(node)) {
            path.addFirst(node);
            if (node.equals(start)) {
                break;
            }
        }
        return path;
    }

    private boolean isFailedEdge(String a, String b, String failedA, String failedB) {
        if (failedA == null || failedB == null) {
            return false;
        }
        return (a.equals(failedA) && b.equals(failedB)) || (a.equals(failedB) && b.equals(failedA));
    }

    public static void main(String[] args) {
        Problem5NetworkPacketRouting network = new Problem5NetworkPacketRouting();
        String[] routers = {"R1", "R2", "R3", "R4", "R5", "R6"};
        for (String router : routers) {
            network.addRouter(router);
        }
        network.addConnection("R1", "R2");
        network.addConnection("R1", "R3");
        network.addConnection("R2", "R4");
        network.addConnection("R3", "R4");
        network.addConnection("R4", "R5");
        network.addConnection("R5", "R6");

        System.out.println(network.isConnected());
        System.out.println(network.minimumHopsPath("R1", "R6"));
        System.out.println(network.alternativePath("R1", "R6", "R4", "R5"));
    }
}
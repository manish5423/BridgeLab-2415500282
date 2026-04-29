import java.util.*;

public class Problem3CityRoadNetwork {
    private static class Edge {
        String to;
        int weight;

        Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private final Map<String, List<Edge>> graph = new LinkedHashMap<>();

    public void addIntersection(String intersection) {
        graph.computeIfAbsent(intersection, key -> new ArrayList<>());
    }

    public void addDirectedRoad(String from, String to, int distance) {
        addIntersection(from);
        addIntersection(to);
        graph.get(from).add(new Edge(to, distance));
    }

    public void addTwoWayRoad(String one, String two, int distance) {
        addDirectedRoad(one, two, distance);
        addDirectedRoad(two, one, distance);
    }

    public Set<String> reachableFrom(String start) {
        Set<String> visited = new LinkedHashSet<>();
        if (!graph.containsKey(start)) {
            return visited;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (Edge edge : graph.getOrDefault(current, Collections.emptyList())) {
                if (visited.add(edge.to)) {
                    queue.add(edge.to);
                }
            }
        }
        return visited;
    }

    public List<String> fewestTurnsPath(String start, String end) {
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
            for (Edge edge : graph.getOrDefault(current, Collections.emptyList())) {
                if (visited.add(edge.to)) {
                    parent.put(edge.to, current);
                    queue.add(edge.to);
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

    public int pathDistance(List<String> path) {
        if (path.size() < 2) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String from = path.get(i);
            String to = path.get(i + 1);
            boolean found = false;
            for (Edge edge : graph.getOrDefault(from, Collections.emptyList())) {
                if (edge.to.equals(to)) {
                    total += edge.weight;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return -1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Problem3CityRoadNetwork network = new Problem3CityRoadNetwork();
        String[] intersections = {"A", "B", "C", "D", "E"};
        for (String intersection : intersections) {
            network.addIntersection(intersection);
        }
        network.addDirectedRoad("A", "B", 5);
        network.addTwoWayRoad("B", "C", 3);
        network.addTwoWayRoad("A", "D", 7);
        network.addDirectedRoad("D", "E", 2);
        network.addDirectedRoad("C", "E", 4);

        System.out.println(network.reachableFrom("A"));
        List<String> path = network.fewestTurnsPath("A", "E");
        System.out.println(path);
        System.out.println(network.pathDistance(path));
    }
}
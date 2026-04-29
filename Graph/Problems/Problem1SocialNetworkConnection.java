import java.util.*;

public class Problem1SocialNetworkConnection {
    private final Map<String, Set<String>> graph = new LinkedHashMap<>();

    public void addUser(String user) {
        graph.computeIfAbsent(user, key -> new LinkedHashSet<>());
    }

    public void addFriendship(String user1, String user2) {
        addUser(user1);
        addUser(user2);
        graph.get(user1).add(user2);
        graph.get(user2).add(user1);
    }

    public Set<String> getFriends(String user) {
        return new LinkedHashSet<>(graph.getOrDefault(user, Collections.emptySet()));
    }

    public boolean areDirectlyConnected(String user1, String user2) {
        return graph.containsKey(user1) && graph.get(user1).contains(user2);
    }

    public List<String> shortestPath(String start, String end) {
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

    public int degreeOfSeparation(String start, String end) {
        List<String> path = shortestPath(start, end);
        return path.isEmpty() ? -1 : path.size() - 1;
    }

    public static void main(String[] args) {
        Problem1SocialNetworkConnection network = new Problem1SocialNetworkConnection();
        String[] users = {"Alice", "Bob", "Charlie", "David", "Eve"};
        for (String user : users) {
            network.addUser(user);
        }
        network.addFriendship("Alice", "Bob");
        network.addFriendship("Alice", "Charlie");
        network.addFriendship("Bob", "David");
        network.addFriendship("Charlie", "Eve");
        network.addFriendship("David", "Eve");

        System.out.println(network.getFriends("Alice"));
        System.out.println(network.areDirectlyConnected("Bob", "Eve"));
        System.out.println(network.shortestPath("Alice", "Eve"));
        System.out.println(network.degreeOfSeparation("Alice", "Eve"));
    }
}
import java.util.*;

public class Problem2CoursePrerequisiteSystem {
    private final Map<String, Set<String>> graph = new LinkedHashMap<>();
    private final Map<String, Set<String>> reverseGraph = new LinkedHashMap<>();

    public void addCourse(String course) {
        graph.computeIfAbsent(course, key -> new LinkedHashSet<>());
        reverseGraph.computeIfAbsent(course, key -> new LinkedHashSet<>());
    }

    public void addPrerequisite(String prerequisite, String course) {
        addCourse(prerequisite);
        addCourse(course);
        graph.get(prerequisite).add(course);
        reverseGraph.get(course).add(prerequisite);
    }

    public boolean hasCycle() {
        Map<String, Integer> state = new HashMap<>();
        for (String course : graph.keySet()) {
            if (detectCycle(course, state)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycle(String course, Map<String, Integer> state) {
        Integer currentState = state.get(course);
        if (currentState != null) {
            return currentState == 1;
        }
        state.put(course, 1);
        for (String next : graph.getOrDefault(course, Collections.emptySet())) {
            if (detectCycle(next, state)) {
                return true;
            }
        }
        state.put(course, 2);
        return false;
    }

    public Set<String> prerequisitesBefore(String course) {
        Set<String> result = new LinkedHashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(course);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            for (String prerequisite : reverseGraph.getOrDefault(current, Collections.emptySet())) {
                if (result.add(prerequisite)) {
                    stack.push(prerequisite);
                }
            }
        }
        return result;
    }

    public List<String> topologicalOrder() {
        Map<String, Integer> indegree = new HashMap<>();
        for (String course : graph.keySet()) {
            indegree.put(course, 0);
        }
        for (Set<String> neighbors : graph.values()) {
            for (String neighbor : neighbors) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }
        Queue<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            for (String next : graph.getOrDefault(current, Collections.emptySet())) {
                int degree = indegree.get(next) - 1;
                indegree.put(next, degree);
                if (degree == 0) {
                    queue.add(next);
                }
            }
        }
        return order.size() == indegree.size() ? order : Collections.emptyList();
    }

    public static void main(String[] args) {
        Problem2CoursePrerequisiteSystem system = new Problem2CoursePrerequisiteSystem();
        String[] courses = {"CS101", "CS102", "CS201", "CS202", "MATH101"};
        for (String course : courses) {
            system.addCourse(course);
        }
        system.addPrerequisite("CS101", "CS102");
        system.addPrerequisite("CS101", "CS201");
        system.addPrerequisite("CS102", "CS202");
        system.addPrerequisite("MATH101", "CS201");

        System.out.println(system.hasCycle());
        System.out.println(system.prerequisitesBefore("CS202"));
        System.out.println(system.topologicalOrder());
    }
}
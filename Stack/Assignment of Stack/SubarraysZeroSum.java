import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class SubarraysZeroSum {
    static class Pair {
        int first, second;
        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    public static List<Pair> findSubarrays(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Pair> result = new ArrayList<>();
        int sum = 0;

        map.computeIfAbsent(0, k -> new ArrayList<>()).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int start : indices) {
                    result.add(new Pair(start + 1, i));
                }
            }
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<Pair> out = findSubarrays(arr);
        for (Pair p : out) {
            System.out.println("Subarray found from index " + p.first + " to " + p.second);
        }
    }
}

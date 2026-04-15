import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllSubarraysWithZeroSum {
    public static List<int[]> findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            List<Integer> indices = map.get(sum);
            if (indices != null) {
                for (int startIndex : indices) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        List<int[]> subarrays = findSubarrays(arr);
        for (int[] range : subarrays) {
            System.out.println(range[0] + " " + range[1]);
        }
    }
}

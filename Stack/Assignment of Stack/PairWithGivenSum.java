import java.util.HashSet;

public class PairWithGivenSum {
    public static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(target - x)) {
                System.out.println("Pair found: (" + x + ", " + (target - x) + ")");
                return true;
            }
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 16;
        if (!hasPair(arr, target)) {
            System.out.println("No pair found");
        }
    }
}

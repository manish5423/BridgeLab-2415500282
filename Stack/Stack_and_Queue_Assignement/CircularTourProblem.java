public class CircularTourProblem {
    public static int findStart(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;
        int tank = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            tank += petrol[i] - distance[i];
            if (tank < 0) {
                deficit += tank;
                start = i + 1;
                tank = 0;
            }
        }

        return (tank + deficit >= 0) ? start % n : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};
        System.out.println(findStart(petrol, distance));
    }
}

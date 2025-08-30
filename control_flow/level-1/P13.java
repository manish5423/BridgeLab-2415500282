import java.util.*;
class P13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 0) {
            int sum1 = 0;
            for (int i = 1; i <= n; i++) sum1 += i;
            int sum2 = n * (n + 1) / 2;
            System.out.println("For sum = " + sum1 + " Formula sum = " + sum2);
        } else {
            System.out.println("Not a natural number");
        }
    }
}
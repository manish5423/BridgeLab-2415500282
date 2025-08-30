import java.util.*;
class P15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 0) {
            long f = 1;
            for (int i = 1; i <= n; i++) f *= i;
            System.out.println(f);
        } else {
            System.out.println("Not a natural number");
        }
    }
}
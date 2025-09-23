import java.util.Scanner;

class SumOfNaturalNumbers {

    public int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        SumOfNaturalNumbers sn = new SumOfNaturalNumbers();
        System.out.println("Sum of first " + n + " natural numbers = " + sn.findSum(n));
    }
}

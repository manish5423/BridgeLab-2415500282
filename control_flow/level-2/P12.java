import java.util.Scanner;
public class P12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.print("Enter power: ");
        int power = sc.nextInt();
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        System.out.println("Result: " + result);
        sc.close();
    }
}
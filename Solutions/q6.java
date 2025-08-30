import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();
        System.out.print("Enter Rate (%): ");
        double rate = sc.nextDouble();
        System.out.print("Enter Time (years): ");
        double time = sc.nextDouble();
        double interest = (principal * rate * time) / 100;
        System.out.println("Simple Interest = " + interest);
        sc.close();
    }
}

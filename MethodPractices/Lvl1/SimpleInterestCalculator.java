import java.util.Scanner;

class SimpleInterestCalculator {

    public double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time: ");
        double time = scanner.nextDouble();

        SimpleInterestCalculator sic = new SimpleInterestCalculator();
        double simpleInterest = sic.calculateSimpleInterest(principal, rate, time);

        System.out.println("The Simple Interest is " + simpleInterest +
                " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }
}

import java.util.Scanner;
public class L3P10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double first = sc.nextDouble();
        System.out.print("Enter second number: ");
        double second = sc.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);
        double result;

        switch(op) {
            case '+':
                result = first + second;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = first - second;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = first * second;
                System.out.println("Result: " + result);
                break;
            case '/':
                if(second != 0) {
                    result = first / second;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;
            default:
                System.out.println("Invalid Operator.");
        }
    }
}
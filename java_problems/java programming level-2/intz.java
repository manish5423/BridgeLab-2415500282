import java.util.Scanner;

public class intz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        int a = sc.nextInt();

        System.out.print("Enter value of b: ");
        int b = sc.nextInt();

        System.out.print("Enter value of c: ");
        int c = sc.nextInt();

        int result1 = a + b * c;    // precedence: b*c first
        int result2 = a * b + c;    // precedence: a*b first
        int result3 = c + a / b;    // precedence: a/b first
        int result4 = a % b + c;    // precedence: a%b first

        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " 
                           + result3 + ", and " + result4);
    }
}

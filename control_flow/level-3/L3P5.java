import java.util.Scanner;
public class L3P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int originalNum = num, sum = 0;

        while(originalNum != 0) {
            int digit = originalNum % 10;
            sum += digit * digit * digit;
            originalNum /= 10;
        }

        if(sum == num)
            System.out.println(num + " is an Armstrong Number.");
        else
            System.out.println(num + " is not an Armstrong Number.");
    }
}
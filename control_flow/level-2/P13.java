import java.util.Scanner;
public class P13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number less than 100: ");
        int number = sc.nextInt();
        int counter = 100;
        while (counter >= 1) {
            if (counter % number == 0)
                System.out.println(counter);
            counter--;
        }
        sc.close();
    }
}
import java.util.Scanner;

class SmallestLargest {

    public int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number1: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter number2: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter number3: ");
        int num3 = scanner.nextInt();

        SmallestLargest sl = new SmallestLargest();
        int[] result = sl.findSmallestAndLargest(num1, num2, num3);

        System.out.println("Smallest = " + result[0] + ", Largest = " + result[1]);
    }
}

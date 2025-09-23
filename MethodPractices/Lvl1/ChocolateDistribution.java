import java.util.Scanner;

class ChocolateDistribution {

    public int[] distributeChocolates(int numberOfChocolates, int numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        return new int[]{chocolatesPerChild, remainingChocolates};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = scanner.nextInt();

        System.out.print("Enter number of children: ");
        int children = scanner.nextInt();

        ChocolateDistribution cd = new ChocolateDistribution();
        int[] result = cd.distributeChocolates(chocolates, children);

        System.out.println("Each child gets " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates = " + result[1]);
    }
}

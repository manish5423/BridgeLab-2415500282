import java.util.Scanner;

class TriangularPark {

    public double calculateRounds(double side1, double side2, double side3, double distance) {
        double perimeter = side1 + side2 + side3;
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side1: ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side2: ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side3: ");
        double side3 = scanner.nextDouble();

        double distance = 5000; // meters = 5 km

        TriangularPark tp = new TriangularPark();
        double rounds = tp.calculateRounds(side1, side2, side3, distance);

        System.out.println("Number of rounds required = " + Math.ceil(rounds));
    }
}

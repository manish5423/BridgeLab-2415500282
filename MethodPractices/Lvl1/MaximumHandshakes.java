import java.util.Scanner;

class MaximumHandshakes {

    public int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();

        MaximumHandshakes mh = new MaximumHandshakes();
        int handshakes = mh.calculateHandshakes(students);

        System.out.println("Maximum possible handshakes = " + handshakes);
    }
}

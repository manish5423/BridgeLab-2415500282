import java.util.Scanner;
public class L3P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks in Physics: ");
        int phy = sc.nextInt();
        System.out.print("Enter marks in Chemistry: ");
        int chem = sc.nextInt();
        System.out.print("Enter marks in Maths: ");
        int math = sc.nextInt();

        double avg = (phy + chem + math) / 3.0;
        System.out.println("Average Marks: " + avg);

        if(avg >= 90) {
            System.out.println("Grade: A (Excellent)");
        } else if(avg >= 75) {
            System.out.println("Grade: B (Very Good)");
        } else if(avg >= 60) {
            System.out.println("Grade: C (Good)");
        } else if(avg >= 40) {
            System.out.println("Grade: D (Pass)");
        } else {
            System.out.println("Grade: F (Fail)");
        }
    }
}
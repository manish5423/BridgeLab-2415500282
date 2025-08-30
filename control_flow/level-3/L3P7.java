import java.util.Scanner;
public class L3P7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight (kg): ");
        double weight = sc.nextDouble();
        System.out.print("Enter height (cm): ");
        double height = sc.nextDouble();
        height = height / 100; // convert cm to m

        double bmi = weight / (height * height);
        System.out.println("BMI: " + bmi);

        if(bmi < 18.5)
            System.out.println("Underweight");
        else if(bmi < 25)
            System.out.println("Normal weight");
        else if(bmi < 30)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }
}
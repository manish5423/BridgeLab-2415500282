import com.school.data.*;
import com.school.util.*;
public class StudentPerformanceAnalyzer {
    public static void main(String[] args){
        Student s = new Student("Karan", 85, 79, 92);
        Analyzer a = new Analyzer();
        double avg = a.calculateAverage(s);
        String grade = a.findGrade(avg);
        System.out.println(s);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + grade);
    }
}

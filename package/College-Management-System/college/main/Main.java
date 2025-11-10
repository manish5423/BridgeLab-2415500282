package college.main;
import college.student.Student;
import college.faculty.Faculty;
import college.department.Department;
public class CollegeManagementSystem {
    public static void main(String[] args){
        Student s = new Student("S001", "Isha");
        Faculty f = new Faculty("F101", "Prof. Rao");
        Department d = new Department("Computer Science");
        System.out.println("Students:");
        System.out.println(s);
        System.out.println("Faculties:");
        System.out.println(f);
        System.out.println("Departments:");
        System.out.println(d);
    }
}

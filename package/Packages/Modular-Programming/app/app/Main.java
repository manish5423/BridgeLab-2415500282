package app;
import college.student.Student;
public class MainApp {
    public static void main(String[] args){
        Student s = new Student("Rita");
        System.out.println("Student from module collegeinfo: " + s.getName());
    }
}

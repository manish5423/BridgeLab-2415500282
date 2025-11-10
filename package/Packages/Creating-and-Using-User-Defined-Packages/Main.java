import college.student.Student;
import college.faculty.Faculty;
public class CreatingAndUsingUserDefinedPackages {
    public static void main(String[] args){
        Student s = new Student("Asha", "CS101");
        Faculty f = new Faculty("Dr. Mehta", "Data Structures");
        s.displayStudent();
        f.displayFaculty();
    }
}

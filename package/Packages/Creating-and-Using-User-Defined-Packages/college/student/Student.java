package college.student;
public class Student {
    private String name;
    private String roll;
    public Student(String name, String roll){
        this.name = name;
        this.roll = roll;
    }
    public void displayStudent(){
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + roll);
    }
}

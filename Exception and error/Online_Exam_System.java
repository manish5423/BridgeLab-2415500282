import java.io.*;
public class OnlineExamSystem {
    static class InvalidStudentException extends Exception { InvalidStudentException(String m){ super(m); } }
    static boolean validateStudent(String id) throws InvalidStudentException {
        if(!"S100".equals(id)) throw new InvalidStudentException("Student not registered: " + id);
        return true;
    }
    static void submitExam(String studentId) throws IOException, InvalidStudentException {
        validateStudent(studentId);
        if("io".equals(studentId)) throw new IOException("Disk write error");
        System.out.println("Exam submitted for " + studentId);
    }
    public static void main(String[] args){
        try{
            submitExam("S101");
        } catch(InvalidStudentException e){
            System.out.println("Validation failed: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Submission failed due to IO: " + e.getMessage());
        } finally{
            System.out.println("Exam submission process completed.");
        }
    }
}


import java.time.*;
public class OnlineExamSubmission {
    static class LateSubmissionException extends Exception { LateSubmissionException(String m){ super(m); } }
    static class InvalidFileFormatException extends Exception { InvalidFileFormatException(String m){ super(m); } }
    static void submitExam(String fileName, LocalDateTime submissionTime) throws LateSubmissionException, InvalidFileFormatException {
        LocalDateTime deadline = LocalDateTime.of(2025, 11, 1, 23, 59);
        if(!fileName.toLowerCase().endsWith(".pdf")) throw new InvalidFileFormatException("File must be a PDF");
        if(submissionTime.isAfter(deadline)) throw new LateSubmissionException("Submission after deadline: " + submissionTime);
        System.out.println("Submission accepted: " + fileName + " at " + submissionTime);
    }
    public static void main(String[] args){
        try{
            submitExam("answer.docx", LocalDateTime.now());
        } catch(InvalidFileFormatException e){
            System.out.println("Submission failed: invalid file format");
        } catch(LateSubmissionException e){
            System.out.println("Submission failed: late submission");
        }
    }
}


public class StudentGradeParser {
    public static void main(String[] args){
        String[] grades = {"90", "A+", "85", "78", "B"};
        for(String g : grades){
            try{
                int value = Integer.parseInt(g);
                System.out.println("Parsed grade: " + value);
            } catch(NumberFormatException e){
                System.out.println("Invalid grade input: " + g);
            }
        }
    }
}


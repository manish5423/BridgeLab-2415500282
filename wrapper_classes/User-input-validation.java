public class AgeValidation {
    public static boolean isValidAdult(String ageInput){
        try{
            int age = Integer.parseInt(ageInput);
            return age >= 18;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args){
        String[] tests = {"20", "17", "abc", "18"};
        for(String t : tests) System.out.println(t + " -> " + isValidAdult(t));
    }
}


import java.util.regex.Pattern;
interface SecurityUtils {
    static boolean isStrongPassword(String pwd){
        if(pwd == null) return false;
        boolean lengthOk = pwd.length() >= 8;
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(pwd).find();
        boolean hasLower = Pattern.compile("[a-z]").matcher(pwd).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(pwd).find();
        boolean hasSymbol = Pattern.compile("[^A-Za-z0-9]").matcher(pwd).find();
        return lengthOk && hasUpper && hasLower && hasDigit && hasSymbol;
    }
}
public class PasswordValidatorDemo {
    public static void main(String[] args){
        String[] samples = {"weakpass", "Strong1!", "NoDigits!", "Short1!"};
        for(String p : samples){
            System.out.println(p + " -> " + (SecurityUtils.isStrongPassword(p) ? "STRONG" : "WEAK"));
        }
    }
}

import java.util.function.Function;
public class StringLengthChecker {
    public static void main(String[] args){
        Function<String, Integer> lengthCalculator = s -> s == null ? 0 : s.length();
        String[] messages = {"Short", "This message is too long to pass the check", ""};
        int limit = 20;
        for(String msg : messages){
            int len = lengthCalculator.apply(msg);
            System.out.println("\"" + msg + "\" length=" + len + (len > limit ? " => exceeds " + limit : " => within " + limit));
        }
    }
}

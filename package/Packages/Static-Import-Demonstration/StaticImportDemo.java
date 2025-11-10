import static java.lang.Math.*;
public class StaticImportDemo {
    public static void main(String[] args){
        double a = -9.0;
        double b = 16.0;
        double sqrtB = sqrt(b);
        double powVal = pow(2, 8);
        double maxVal = max(a, b);
        double minVal = min(a, b);
        double absA = abs(a);
        System.out.println("sqrt(16) = " + sqrtB);
        System.out.println("pow(2,8) = " + powVal);
        System.out.println("max(-9,16) = " + maxVal);
        System.out.println("min(-9,16) = " + minVal);
        System.out.println("abs(-9) = " + absA);
    }
}

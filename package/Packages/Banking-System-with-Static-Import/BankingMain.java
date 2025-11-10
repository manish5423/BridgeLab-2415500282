import static java.lang.Math.*;
import com.bank.util.InterestCalculator;
public class BankingStaticImportDemo {
    public static void main(String[] args){
        double p = 10000;
        double r = 5;
        double t = 2;
        double si = InterestCalculator.calculateSimpleInterest(p, r, t);
        double ci = InterestCalculator.calculateCompoundInterest(p, r, t);
        System.out.println("Simple Interest = " + si);
        System.out.println("Compound Interest = " + ci);
        System.out.println("pow(1.05,2) via static import = " + pow(1.05, 2));
    }
}

interface PaymentProcessor {
    boolean processPayment(double amount);
    default boolean refund(double amount){
        System.out.println("Default refund processed for " + amount);
        return true;
    }
}
class ProviderA implements PaymentProcessor {
    public boolean processPayment(double amount){
        System.out.println("ProviderA processed payment " + amount);
        return true;
    }
}
class ProviderB implements PaymentProcessor {
    public boolean processPayment(double amount){
        System.out.println("ProviderB processed payment " + amount);
        return true;
    }
    public boolean refund(double amount){
        System.out.println("ProviderB custom refund of " + amount);
        return true;
    }
}
public class PaymentGatewayDemo {
    public static void main(String[] args){
        PaymentProcessor p1 = new ProviderA();
        PaymentProcessor p2 = new ProviderB();
        p1.processPayment(120.0);
        p2.processPayment(250.0);
        p1.refund(50.0);
        p2.refund(75.0);
    }
}

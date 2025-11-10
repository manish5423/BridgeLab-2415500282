interface Payment {
    boolean pay(double amount);
}
class UPI implements Payment {
    private String vpa;
    UPI(String vpa){ this.vpa = vpa; }
    public boolean pay(double amount){
        System.out.println("Processing UPI payment of " + amount + " from " + vpa);
        return true;
    }
}
class CreditCard implements Payment {
    private String cardNumber;
    CreditCard(String cardNumber){ this.cardNumber = cardNumber; }
    public boolean pay(double amount){
        System.out.println("Charging " + amount + " to card " + cardNumber.substring(cardNumber.length()-4));
        return true;
    }
}
class Wallet implements Payment {
    private String walletName;
    private double balance;
    Wallet(String walletName, double balance){ this.walletName = walletName; this.balance = balance; }
    public boolean pay(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Paid " + amount + " from " + walletName + " wallet. Remaining balance " + balance);
            return true;
        } else {
            System.out.println("Insufficient wallet balance for " + amount);
            return false;
        }
    }
}
public class DigitalPaymentDemo {
    public static void main(String[] args){
        Payment upi = new UPI("ram@bank");
        Payment card = new CreditCard("4111222233334444");
        Payment wallet = new Wallet("FastPay", 500.0);
        upi.pay(150.0);
        card.pay(999.99);
        wallet.pay(250.0);
        wallet.pay(300.0);
    }
}

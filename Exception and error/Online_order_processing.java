import java.util.*;
public class OnlineOrderProcessing {
    static class OutOfStockException extends Exception {
        OutOfStockException(String msg){ super(msg); }
    }
    static class PaymentFailedException extends Exception {
        PaymentFailedException(String msg){ super(msg); }
    }
    static void placeOrder() throws OutOfStockException, PaymentFailedException {
        int outcome = new Random().nextInt(3);
        if(outcome == 0) throw new OutOfStockException("Product is out of stock");
        if(outcome == 1) throw new PaymentFailedException("Payment authorization failed");
        System.out.println("Order placed successfully");
    }
    public static void main(String[] args){
        try{
            placeOrder();
        } catch(OutOfStockException e){
            System.out.println("Order error: " + e.getMessage());
        } catch(PaymentFailedException e){
            System.out.println("Payment error: " + e.getMessage());
        }
    }
}


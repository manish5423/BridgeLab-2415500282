import java.util.*;
public class BankingTransactionSystem {
    static class NegativeAmountException extends Exception { NegativeAmountException(String m){ super(m); } }
    static class InsufficientFundsException extends Exception { InsufficientFundsException(String m){ super(m); } }
    static class NetworkFailureException extends Exception { NetworkFailureException(String m){ super(m); } }
    static class Transaction {
        void process(double amount, double balance) throws NegativeAmountException, InsufficientFundsException, NetworkFailureException {
            int pick = new Random().nextInt(3);
            if(amount < 0) throw new NegativeAmountException("Amount cannot be negative: " + amount);
            if(pick == 0) throw new InsufficientFundsException("Balance ?" + balance + " insufficient for ?" + amount);
            if(pick == 1) throw new NetworkFailureException("Network error while processing transaction");
            System.out.println("Transaction of ?" + amount + " completed");
        }
    }
    public static void main(String[] args){
        Transaction t = new Transaction();
        try{
            t.process(5000, 3000);
        } catch(NegativeAmountException e){
            System.out.println("Invalid transaction: " + e.getMessage());
        } catch(InsufficientFundsException e){
            System.out.println("Transaction failed: " + e.getMessage());
        } catch(NetworkFailureException e){
            System.out.println("Please retry later: " + e.getMessage());
        }
    }
}


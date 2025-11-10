public class BankTransactionManager {
    static class AccountNotFoundException extends Exception { AccountNotFoundException(String m){ super(m); } }
    static class InsufficientFundsException extends Exception { InsufficientFundsException(String m){ super(m); } }
    static void verifyAccount(String acc) throws AccountNotFoundException {
        if(!"ACC100".equals(acc)) throw new AccountNotFoundException("Account not found: " + acc);
    }
    static void processTransaction(String acc, double amount, double balance) throws InsufficientFundsException {
        if(amount > balance) throw new InsufficientFundsException("Insufficient funds for account " + acc);
        System.out.println("Transaction of ?" + amount + " processed for " + acc);
    }
    static void executeTransaction(String acc, double amount, double balance) throws Exception {
        verifyAccount(acc);
        processTransaction(acc, amount, balance);
    }
    public static void main(String[] args){
        try{
            executeTransaction("ACC200", 5000, 4000);
        } catch(AccountNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        } catch(InsufficientFundsException e){
            System.out.println("Error: " + e.getMessage());
        } catch(Exception e){
            System.out.println("Transaction error: " + e.getMessage());
        } finally{
            System.out.println("Transaction complete.");
        }
    }
}


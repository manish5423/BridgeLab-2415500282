public class ATMWithdrawalSystem {
    static class InsufficientFundsException extends Exception {
        InsufficientFundsException(String msg){ super(msg); }
    }
    static class ATM {
        private int balance;
        ATM(int balance){ this.balance = balance; }
        void withdraw(int amount) throws InsufficientFundsException {
            if(amount > balance) throw new InsufficientFundsException("Requested ?" + amount + " exceeds available balance ?" + balance);
            balance -= amount;
            System.out.println("Withdrawal successful: ?" + amount + ". Remaining balance: ?" + balance);
        }
    }
    public static void main(String[] args){
        ATM atm = new ATM(10000);
        try{
            atm.withdraw(12000);
        } catch(InsufficientFundsException e){
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}


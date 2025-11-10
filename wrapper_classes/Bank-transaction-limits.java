public class BankTransactionLimits {
    public static double remainingLimit(Double dailyLimit, double used){
        if(dailyLimit == null) return 0.0;
        return Math.max(0.0, dailyLimit - used);
    }
    public static void main(String[] args){
        Double limit1 = 10000.0;
        Double limit2 = null;
        System.out.println("Remaining1 = " + remainingLimit(limit1, 2500));
        System.out.println("Remaining2 = " + remainingLimit(limit2, 1000));
    }
}


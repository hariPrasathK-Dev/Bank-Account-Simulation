public class SavingsAccount extends Account {
    private static final double interest_rate = 0.03 ;
    public SavingsAccount(int accountNumber, String holderName) {
        super(accountNumber, holderName);
    }

    @Override
    public void deposit(double amount) {
        double interest = amount* interest_rate ;
        balance +=  (amount + interest) ;
        transxnHistory.add("Deposited ₹" + amount + " + ₹" + interest + " interest") ;
    }
}

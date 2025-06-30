import java.util.ArrayList ;

public class Account {
    protected int accountNumber ;
    protected String holderName ;
    protected double balance ;
    ArrayList<String> transxnHistory = new ArrayList<>() ;

    public Account(int accountNumber,String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        transxnHistory.add("Deposited : ₹"+amount) ;
    }

    public void withDraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            transxnHistory.add("Withdrawal : ₹"+amount) ;
        }
        else {
            System.err.println("Withdrawal failed ! Insufficient funds!") ;
        }
    }

    public void getTransactions() {
        for(String trxn : transxnHistory)
        {
            System.out.println(trxn) ;
        }
    }

    public void getBalance() {
        System.out.println("Balance : "+balance) ;
    }

    public void getAccountDetails() {
        System.out.println("Account Number : "+accountNumber) ;
        System.out.println("Holder Name : "+holderName) ;
        System.out.println("Balance : ₹ "+balance) ;
    }
}

import java.util.ArrayList ;
import java.util.Scanner ;

public class BankSystem {
    ArrayList<Account> accounts = new ArrayList<>() ;
    Scanner scanner = new Scanner(System.in) ;
    public void start() {
        int choice;
        do {
            System.out.println("1) Create Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) View Balance");
            System.out.println("5) View Transaction History");
            System.out.println("6) Exit");
            System.out.print("Enter your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> performTransaction("deposit");
                case 3 -> performTransaction("withdraw");
                case 4 -> viewBalance();
                case 5 -> viewTransactions();
                case 6 -> System.out.println("Thank you for banking with us!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private void createAccount() {
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        int accno = accounts.size() + 1001 ;

        System.out.println("Account type(1-Savings Account") ;
        int type = scanner.nextInt() ;
        Account newAccount ;
        if(type == 1)
        {
            newAccount = new SavingsAccount(accno,name) ;
        }
        else {
            newAccount = new Account(accno,name) ;
        }
        accounts.add(newAccount) ;
        System.out.println("Account created ! Account number : "+accno) ;
    }

    private Account findAccount()
    {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        for(Account account : accounts)
        {
            if (account.accountNumber== accNo) {
                return account ;
            }
        }
        return null ;
    }
    private void performTransaction(String type)
    {
        Account account = findAccount() ;

        if(account == null) return ;

        System.out.println("Enter Amount : ") ;
        double amount = scanner.nextDouble() ;

        if(type.equals("deposit")) {
            account.deposit(amount) ;
        }
        else {
            account.withDraw(amount);
        }
    }

    private void viewBalance() {
        Account account = findAccount() ;
        if(account != null) {
            account.getBalance();
        }
    }

    private void viewTransactions() {
        Account account = findAccount() ;

        if(account != null)
        {
            account.getTransactions();
        }
    }
}

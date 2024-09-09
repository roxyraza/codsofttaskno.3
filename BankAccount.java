public class bankaccount {
    private double balance;
    private String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Deposit amount must be positive.");
            return false;
        }
    }

 
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

  
    public String getAccountNumber() {
        return accountNumber;
    }

 
    public String getAccountHolderName() {
        return accountHolderName;
    }

 
    public static void main(String[] args) {
      
        BankAccount account = new BankAccount("1234567890", "John Doe", 1000.0);

        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: $" + account.getBalance());

        if (account.deposit(500.0)) {
            System.out.println("Deposit successful. New balance: $" + account.getBalance());
        }


        if (account.withdraw(200.0)) {
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        }

        if (!account.withdraw(2000.0)) {
            System.out.println("Failed to withdraw money. Current balance: $" + account.getBalance());
        }

        if (!account.deposit(-100.0)) {
            System.out.println("Failed to deposit money. Current balance: $" + account.getBalance());
        }
    }
    
}

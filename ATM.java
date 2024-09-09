public class ATM {
    private double balance;
    private String pin;

    public ATM(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

  
    public double checkBalance(String enteredPin) {
        if (validatePin(enteredPin)) {
            return balance;
        } else {
            System.out.println("Invalid PIN.");
            return -1; 
        }
    }

    public boolean deposit(double amount, String enteredPin) {
        if (validatePin(enteredPin)) {
            if (amount > 0) {
                balance += amount;
                return true;
            } else {
                System.out.println("Deposit amount must be positive.");
                return false;
            }
        } else {
            System.out.println("Invalid PIN.");
            return false;
        }
    }

   
    public boolean withdraw(double amount, String enteredPin) {
        if (validatePin(enteredPin)) {
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
        } else {
            System.out.println("Invalid PIN.");
            return false;
        }
    }

    private boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0, "1234");

       
        System.out.println("Balance: $" + atm.checkBalance("1234"));

        
        if (atm.deposit(500.0, "1234")) {
            System.out.println("Deposit successful.");
        }

        if (atm.withdraw(200.0, "1234")) {
            System.out.println("Withdrawal successful.");
        }

        System.out.println("Balance: $" + atm.checkBalance("0000"));

        if (!atm.withdraw(2000.0, "1234")) {
            System.out.println("Failed to withdraw money.");
        }

        if (!atm.deposit(-100.0, "1234")) {
            System.out.println("Failed to deposit money.");
        }
    }

}
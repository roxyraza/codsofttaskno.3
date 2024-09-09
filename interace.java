import java.util.Scanner; 
public class interace {

 private double balance;
    private String pin;

    public ATM(Double InitialBalance, String Pin) {
        this.balance = InitialBalance;
        this.pin = pin;
    }

  
    public double checkBalance(String enteredPin) {
        if (validatePin(enteredPin)) {
            return balance;
        } else {
            System.out.println("Invalid PIN.");
            return -1; /
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
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000.0, "1234"); 

        System.out.println("Welcome to the ATM");

        boolean exit = false;

        while (!exit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter PIN: ");
                    String pin = scanner.nextLine();
                    double balance = atm.checkBalance(pin);
                    if (balance != -1) {
                        System.out.println("Your balance is: $" + balance);
                    }
                    break;

                case 2:
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextLine();
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    if (atm.deposit(depositAmount, pin)) {
                        System.out.println("Deposit successful.");
                    }
                    break;

                case 3:
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (atm.withdraw(withdrawAmount, pin)) {
                        System.out.println("Withdrawal successful.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
    
}

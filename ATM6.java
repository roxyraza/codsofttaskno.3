import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM6 {
    private bankaccount bankAccount;
    private String pin;

  
    public ATM6(bankaccount bankAccount, String pin) {
        this.bankAccount = bankAccount;
        this.pin = pin;
    }

  
    public double checkBalance(String enteredPin) {
        if (validatePin(enteredPin)) {
            return bankAccount.getBalance();
        } else {
            System.out.println("Invalid PIN.");
            return -1; 
        }
    }

    public boolean deposit(double amount, String enteredPin) {
        if (validatePin(enteredPin)) {
            return bankAccount.deposit(amount);
        } else {
            System.out.println("Invalid PIN.");
            return false;
        }
    }

    public boolean withdraw(double amount, String enteredPin) {
        if (validatePin(enteredPin)) {
            return bankAccount.withdraw(amount);
        } else {
            System.out.println("Invalid PIN.");
            return false;
        }
    }

   
    private boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
     
        bankaccount account = New BankAccount("1234567890", "John Doe", 1000.0);
        
       
        ATM atm = new ATM6(account, "1234");

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
                    double depositAmount = readDouble(scanner);
                    if (depositAmount > 0) {
                        if (atm.deposit(depositAmount, pin)) {
                            System.out.println("Deposit successful. New balance: $" + atm.checkBalance(pin));
                        }
                    } else {
                        System.out.println("Deposit amount must be positive.");
                    }
                    break;

                case 3:
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = readDouble(scanner);
                    if (withdrawAmount > 0) {
                        if (atm.withdraw(withdrawAmount, pin)) {
                            System.out.println("Withdrawal successful. New balance: $" + atm.checkBalance(pin));
                        }
                    } else {
                        System.out.println("Withdrawal amount must be positive.");
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

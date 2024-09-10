package atm;
import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    public ATM(int initialPin, double initialBalance) {
        this.pin = initialPin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Account opened with balance: " + initialBalance);
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: " + this.balance);
        transactionHistory.add("Checked balance: " + this.balance);
    }

    // Method to withdraw cash
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
            System.out.println("New balance: " + this.balance);
            transactionHistory.add("Withdrew: " + amount + " | Remaining balance: " + this.balance);
        }
    }

    // Method to deposit cash
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
            System.out.println("New balance: " + this.balance);
            transactionHistory.add("Deposited: " + amount + " | New balance: " + this.balance);
        }
    }

    // Method to change PIN
    public void changePin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN successfully changed.");
            transactionHistory.add("PIN changed.");
        } else {
            System.out.println("Incorrect old PIN!");
        }
    }

    // Method to show transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Main menu to interact with ATM
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1234, 1000.00);

        while (true) {
            System.out.println("\nATM Machine:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter old PIN: ");
                    int oldPin = scanner.nextInt();
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    atm.changePin(oldPin, newPin);
                    break;
                case 5:
                    atm.showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


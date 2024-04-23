import java.util.*;

//BankAccount Class
class BankAccount {
    private double balance;

    // Declaring Balance method
    public BankAccount(double initialBalance) {
        if (initialBalance > 0)
            balance = initialBalance;
    }

    // Declaring Credit method
    public void credit(double amount) {
        balance += amount;
    }

    // Declaring Debit method
    public boolean debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient money.");
            return false;
        }
    }

    // Get balance method
    public double getBalance() {
        return balance;
    }
}

// ATM Class
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    // ATM method
    public ATM(BankAccount account) {
        this.account = account;
    }

    // displayMainMenu method
    public void displayMainMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposite Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");
    }

    // execute method
    public void execute() {
        int choice;
        double amount;

        do {
            displayMainMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    amount = sc.nextDouble();
                    deposit(amount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    amount = sc.nextDouble();
                    withdraw(amount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    // Calling checkBalance method
    public void checkBalance() {
        System.out.printf("Your bank balance is: $%.2f%n", account.getBalance());
    }

    // Calling deposit method
    public void deposit(double amount) {
        account.credit(amount);
        System.out.printf("Deposited $%.2f. Your new bank balance is: $%.2f%n", amount, account.getBalance());
    }

    // Calling withdraw method
    public void withdraw(double amount) {
        if (account.debit(amount))
            System.out.printf("Withdraw $%.2f. Your new bank balance is: $%.2f%n", amount, account.getBalance());
    }
}

// ATMInterface Class
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        System.out.println("Welcome to the ATM!");
        atm.execute();
    }
}

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println();
            System.out.println("Deposited: Rs. " + amount+"/-");
        } else {
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println();
            System.out.println("Invalid amount for deposit.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println();
            System.out.println("Withdrawn: Rs. " + amount+"/-");
            return true;
        } else {
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println();
            System.out.println("Invalid amount for withdrawal or insufficient balance in your account.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        userAccount = account;
    }

    public void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("Account Balance: Rs. " + balance+"/-");
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        userAccount.withdraw(amount);
    }
}

public class ATMProgram {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(0.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("Select an action to proceed:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount you want to deposit: Rs. ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount you want to withdraw: Rs. ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("---------------------------------------");
                    System.out.println();
                    System.out.println("Thank you for using the ATM. Come back again! Goodbye!!!");
                    System.out.println();
                    System.out.println("---------------------------------------");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println();
                    System.out.println("---------------------------------------");
                    System.out.println();
                    System.out.println("Invalid choice. Please select a valid option from the given list of actions.");
            }
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println();
        }
    }
}

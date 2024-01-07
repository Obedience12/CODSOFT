import java.util.Scanner;

class Account {
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    public double showBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + "succesful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdrawAmnt(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + "successful. ");
        } else {
            System.out.println("Ivalid withdrawal or insufficient balance.");
        }
    }

}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBalance = 1000.0;
        Account userAccount = new Account(initialBalance);

        System.out.println("WELCOME TO ATM!!!!");

        while (true) {
            System.out.println("ATM Menu: ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: R " + userAccount.showBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to be deposited: R ");
                    double amntdeposit = scanner.nextDouble();
                    userAccount.deposit(amntdeposit);
                    break;
                case 3:
                    System.out.println("Enter amount to be withdrawal: R ");
                    double amntwithdrawal = scanner.nextDouble();
                    userAccount.withdrawAmnt(amntwithdrawal);
                    break;
                case 4:
                    System.out.println("Exiting the ATM. Goodbye!");
                    System.out.println("Do visit again.");
                    scanner.close();
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}

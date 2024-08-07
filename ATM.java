import java.util.Scanner;

public class ATM {
    private static double balance = 1000.00; // Initial balance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + String.format("%.2f", balance));
    }

    private static void depositMoney() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + String.format("%.2f", amount));
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + String.format("%.2f", amount));
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please enter a lower amount.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }
}

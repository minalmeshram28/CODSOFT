import java.util.Scanner;

public class ATM {

    private BankAccount bankAccount;
    private Scanner sc;

    public ATM(BankAccount account) {
        bankAccount = account;
        sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> {
                    System.out.println("Thank you for using the ATM!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = sc.nextDouble();
        bankAccount.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = sc.nextDouble();
        bankAccount.withdraw(amount);
    }
}

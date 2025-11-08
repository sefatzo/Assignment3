import java.util.Scanner;

public class SimpleATM {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double currentBalance = 0.0;

        while (true) {
            System.out.println("\nWelcome to the Simple Console ATM!");
            System.out.println("Please select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: %.2f Taka%n", currentBalance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();

                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount! Deposit must be positive.");
                    } else {
                        currentBalance += depositAmount;
                        System.out.printf("Successfully deposited %.2f Taka.%n", depositAmount);
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw (max 100 Taka per transaction): ");
                    double withdrawAmount = input.nextDouble();

                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount! Withdrawal must be positive.");
                    } else if (withdrawAmount > 100) {
                        System.out.println("You can only withdraw a maximum of 100 Taka per transaction.");
                    } else if (withdrawAmount > currentBalance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        currentBalance -= withdrawAmount;
                        System.out.printf("Successfully withdrawn %.2f Taka.%n", withdrawAmount);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM! Goodbye.");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 4.");
            }
        }
    }
}

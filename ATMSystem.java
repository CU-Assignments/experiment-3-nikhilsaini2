import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMSystem {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            if (pin != CORRECT_PIN) {
                throw new InvalidPINException("Error: Incorrect PIN.");
            }

            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            if (amount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance. Current Balance: " + balance);
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final Balance: " + balance);
            scanner.close();
        }
    }
}

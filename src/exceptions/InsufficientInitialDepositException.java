package exceptions;

public class InsufficientInitialDepositException extends Exception {
    public InsufficientInitialDepositException(double minimumInitialDeposit) {
        super("Insufficient initial deposit. Minimum initial deposit is $" + minimumInitialDeposit);
    }
}

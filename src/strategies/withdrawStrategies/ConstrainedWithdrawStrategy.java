package strategies.withdrawStrategies;

public class ConstrainedWithdrawStrategy implements WithdrawStrategy{
    private final double minimumBalance;
    public ConstrainedWithdrawStrategy(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
    @Override
    public double withdraw(double balance, double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("Insufficient funds");
            return balance;
        }

        System.out.println("Withdrawing $" + amount + " from your account");
        balance -= amount;
        return balance;
    }
}

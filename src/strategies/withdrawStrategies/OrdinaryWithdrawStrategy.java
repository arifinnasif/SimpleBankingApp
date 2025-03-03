package strategies.withdrawStrategies;

public class OrdinaryWithdrawStrategy implements WithdrawStrategy{
    @Override
    public double withdraw(double balance, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return balance;
        }

        System.out.println("Withdrawing $" + amount + " from your account");
        balance -= amount;
        return balance;
    }
}

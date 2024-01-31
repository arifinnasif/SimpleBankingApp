package strategies.withdrawStrategies;

public class OrdinaryWithdrawStrategy implements WithdrawStrategy{
    @Override
    public boolean withdraw(Double balance, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return false;
        }

        System.out.println("Withdrawing $" + amount + " from your account");
        balance -= amount;
        return true;
    }
}

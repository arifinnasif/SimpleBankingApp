package strategies.depositStrategies;

public class OrdinaryDepositStrategy implements DepositStrategy {
    @Override
    public double deposit(double balance, double amount) {
        System.out.println("Depositing $" + amount + " into your account");
        balance += amount;
        return balance;
    }
}

package strategies.depositStrategies;

public class OrdinaryDepositStrategy implements DepositStrategy {
    @Override
    public void deposit(Double balance, double amount) {
        System.out.println("Depositing $" + amount + " into your account");
        balance += amount;
    }
}

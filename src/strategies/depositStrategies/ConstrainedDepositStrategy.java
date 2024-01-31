package strategies.depositStrategies;

public class ConstrainedDepositStrategy implements DepositStrategy{
    private final double maximumDeposit;
    public ConstrainedDepositStrategy(double maximumDeposit) {
        this.maximumDeposit = maximumDeposit;
    }
    @Override
    public double deposit(double balance, double amount) {
        if (amount > this.maximumDeposit) {
            System.out.println("You cannot deposit more than $1000 at a time");
            return balance;
        }

        System.out.println("Depositing $" + amount + " into your account");
        balance += amount;
        return balance;
    }
}

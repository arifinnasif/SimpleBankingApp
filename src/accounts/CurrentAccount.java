package accounts;

import strategies.depositStrategies.ConstrainedDepositStrategy;
import strategies.depositStrategies.DepositStrategy;
import strategies.withdrawStrategies.ConstrainedWithdrawStrategy;
import strategies.withdrawStrategies.WithdrawStrategy;

public class CurrentAccount implements Account{

    private String name;
    private final String number;
    private double balance;

    private final WithdrawStrategy withdrawStrategy;
    private final DepositStrategy depositStrategy;

    public CurrentAccount(String name, String number, double initialDeposit) {
        this.name = name;
        this.number = number;
        this.balance = initialDeposit;
        double minimumBalance = 50;
        this.withdrawStrategy = new ConstrainedWithdrawStrategy(minimumBalance);
        double maximumDeposit = 10000;
        this.depositStrategy = new ConstrainedDepositStrategy(maximumDeposit);
    }

    @Override
    public void deposit(double amount) {
        balance = depositStrategy.deposit(balance, amount);
    }

    @Override
    public void withdraw(double amount) {
        balance = withdrawStrategy.withdraw(balance, amount);
    }

    @Override
    public void displayAccount() {
        System.out.println("Account name: " + name);
        System.out.println("Account number: " + number);
        System.out.println("Account balance: $" + balance);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

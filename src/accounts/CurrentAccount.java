package accounts;

import exceptions.InsufficientInitialDepositException;
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

    public CurrentAccount(String name, String number, double initialDeposit) throws InsufficientInitialDepositException {
        double minimumInitialDeposit = 50;
        double minimumBalance = 50;
        double maximumDeposit = 10000;
        if (initialDeposit < minimumInitialDeposit) {
            throw new InsufficientInitialDepositException(minimumInitialDeposit);
        }
        this.name = name;
        this.number = number;
        this.balance = initialDeposit;

        this.withdrawStrategy = new ConstrainedWithdrawStrategy(minimumBalance);

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
        System.out.println("Account type: Current");
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

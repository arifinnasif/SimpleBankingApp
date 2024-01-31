package accounts;


import strategies.depositStrategies.DepositStrategy;
import strategies.depositStrategies.OrdinaryDepositStrategy;
import strategies.withdrawStrategies.OrdinaryWithdrawStrategy;
import strategies.withdrawStrategies.WithdrawStrategy;

public class SavingsAccount implements Account {
    private String name;
    private String number;
    private double balance;
    private DepositStrategy depositStrategy;
    private WithdrawStrategy withdrawStrategy;

    public SavingsAccount(String name, String number, double initialDeposit) {
        this.name = name;
        this.number = number;
        this.balance = initialDeposit;
        this.depositStrategy = new OrdinaryDepositStrategy();
        this.withdrawStrategy = new OrdinaryWithdrawStrategy();
    }

    public void deposit(double amount) {
        depositStrategy.deposit(balance, amount);
    }

    public boolean withdraw(double amount) {
        return withdrawStrategy.withdraw(balance, amount);
    }

    public void displayAccount() {
        System.out.println("Saving Account: " + name + " - " + number + " - Balance: $" + balance);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public double getBalance() {
        return this.balance;
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
package accounts;


public class SavingsAccount implements Account {
    private final String name;
    private final String number;
    private double balance;

    public SavingsAccount(String name, String number, double initialDeposit) {
        this.name = name;
        this.number = number;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    public void displayAccount() {
        System.out.println("Saving Account: " + name + " - " + number + " - Balance: $" + balance);
    }
}
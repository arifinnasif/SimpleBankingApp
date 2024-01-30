package accounts;

public interface Account {
    void deposit(double amount);
    boolean withdraw(double amount);
    void displayAccount();
}

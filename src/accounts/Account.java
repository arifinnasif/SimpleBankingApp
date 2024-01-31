package accounts;

public interface Account {
    void deposit(double amount);
    boolean withdraw(double amount);
    void displayAccount();

    String getName();
    String getNumber();
    double getBalance();

    void setName(String name);
    void setBalance(double balance);
}

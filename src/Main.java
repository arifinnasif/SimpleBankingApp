import bank.Bank;


public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        bank.createAccount("Saving", "John Doe", "123456789", 1000);
        bank.createAccount("Saving", "Jane Doe", "987654321", 1500);

        bank.displayAccounts();
    }
}
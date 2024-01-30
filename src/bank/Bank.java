package bank;

import accounts.Account;

import java.util.ArrayList;
import java.util.List;

class Bank {
    private static Bank instance;
    private List<Account> accounts;

    private Bank() {
        accounts = new ArrayList<>();
    }

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void createAccount(String type, String name, String number, double initialDeposit) {
        Account account = AccountFactory.createAccount(type, name, number, initialDeposit);
        if (account != null) {
            accounts.add(account);
            System.out.println(type + " account created successfully for " + name);
        } else {
            System.out.println("Invalid account type");
        }
    }

    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
        } else {
            for (Account account : accounts) {
                account.displayAccount();
            }
        }
    }

    // Implement other methods like deleteAccount, updateAccount, etc., as needed
}



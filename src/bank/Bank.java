package bank;

import accounts.Account;
import exceptions.InsufficientInitialDepositException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private static Bank instance;
    private final List<Account> accounts;

    private static final Scanner scanner = new Scanner(System.in);

    private Bank() {
        accounts = new ArrayList<>();
    }

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void createAccount(String type, String name, String number, double initialDeposit) throws InsufficientInitialDepositException {
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
                System.out.println();

            }
        }
    }

    public void updateAccount(String number, String name, double balance) {
        Account account = searchAccount(number);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        account.setName(name);
        account.setBalance(balance);

        System.out.println("Account updated successfully to Name: " + name + " - Balance: " + balance);
    }


    public void deleteAccount(String number) {
        Account account = searchAccount(number);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        accounts.remove(account);

        System.out.println("Account deleted successfully");
    }

    public Account searchAccount(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equals(number)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String number, double amount) {
        Account account = searchAccount(number);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful");
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdraw(String number, double amount) {
        Account account = searchAccount(number);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public int displayMenu() {
        System.out.println("1. Create Account");
        System.out.println("2. Display Accounts");
        System.out.println("3. Update Account");
        System.out.println("4. Delete Account");
        System.out.println("5. Deposit");
        System.out.println("6. Withdraw");
        System.out.println("7. Search Account");
        System.out.println("8. Exit");

        return Integer.parseInt(scanner.nextLine());
    }
}



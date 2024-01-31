package bank;

import accounts.Account;
import accounts.SavingsAccount;

class AccountFactory {
    public static Account createAccount(String type, String name, String number, double initialDeposit) {
        switch (type.toLowerCase()) {
            case "savings":
                return new SavingsAccount(name, number, initialDeposit);
            // Add other account types here
            default:
                return null;
        }
    }
}

package bank;

import accounts.Account;
import accounts.OrdinaryAccount;

class AccountFactory {
    public static Account createAccount(String type, String name, String number, double initialDeposit) {
        switch (type.toLowerCase()) {
            case "savings":
                return new OrdinaryAccount(name, number, initialDeposit);
            // Add other account types here
            default:
                return null;
        }
    }
}

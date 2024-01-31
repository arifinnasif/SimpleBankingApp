package bank;

import accounts.Account;
import accounts.CurrentAccount;
import accounts.OrdinaryAccount;
import accounts.SavingsAccount;
import exceptions.InsufficientInitialDepositException;

class AccountFactory {
    public static Account createAccount(String type, String name, String number, double initialDeposit) throws InsufficientInitialDepositException {
        switch (type.toLowerCase()) {
            case "ordinary":
                return new OrdinaryAccount(name, number, initialDeposit);

            case "current":
                return new CurrentAccount(name, number, initialDeposit);

            case "savings":
                return new SavingsAccount(name, number, initialDeposit);

            default:
                return null;
        }
    }
}

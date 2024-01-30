import accounts.Account;
import bank.Bank;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            int choice = bank.displayMenu();
            String number;
            String name;
            double balance;
            String type;
            double amount;
            switch (choice) {
                case 1:
                    System.out.println("Create a new account");
                    // take input from user
                    System.out.println("Enter account type: ");
                    type = scanner.nextLine();
                    System.out.println("Enter account name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter account number: ");
                    number = scanner.nextLine(); // in real world, we should use a random string and validate the account number
                    System.out.println("Enter initial deposit: ");
                    balance = scanner.nextDouble();

                    bank.createAccount(type, name, number, balance);
                    break;
                case 2:
                    System.out.println("Display all accounts");
                    bank.displayAccounts();
                    break;
                case 3:
                    System.out.println("Update an account");
                    // take input from user
                    System.out.println("Enter Account Number: ");
                    number = scanner.nextLine();
                    System.out.println("Enter New Name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter New Balance: ");
                    balance = scanner.nextDouble();

                    bank.updateAccount(number, name, balance);
                    break;
                case 4:
                    System.out.println("Delete an account");
                    // take input from user
                    System.out.println("Enter Account Number: ");
                    number = scanner.nextLine();

                    bank.deleteAccount(number);
                    break;
                case 5:
                    System.out.println("Deposit to an account");
                    // take input from user
                    System.out.println("Enter Account Number: ");
                    number = scanner.nextLine();
                    System.out.println("Enter Amount to Deposit: ");
                    amount = scanner.nextDouble();
                    bank.deposit(number, amount);
                    break;
                case 6:
                    System.out.println("Withdraw from an account");
                    // take input from user
                    System.out.println("Enter Account Number: ");
                    number = scanner.nextLine();
                    System.out.println("Enter Amount to Withdraw: ");
                    amount = scanner.nextDouble();
                    bank.withdraw(number, amount);
                    break;
                case 7:
                    System.out.println("Search for an account");
                    // take input from user
                    System.out.println("Enter Account Number: ");
                    number = scanner.nextLine();
                    Account temp = bank.searchAccount(number);
                    if (temp != null) {
                        temp.displayAccount();
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 8:
                    System.out.println("Thank you for using our services");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
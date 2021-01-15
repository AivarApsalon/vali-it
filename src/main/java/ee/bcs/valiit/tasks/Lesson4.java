package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");
            if (command.equalsIgnoreCase("createAccount")) {
                System.out.println("Please type new account nr: ");
                String accountNr = scanner.nextLine();
                accountBalanceMap.put(accountNr, new BigDecimal(0));
                System.out.println("Account nr:" + accountNr + " created! Balance: " + accountBalanceMap.get(accountNr));

            } else if (command.equalsIgnoreCase("getBalance")) {
                System.out.println("Type account number you search: ");
                String getAccountNr = scanner.nextLine();
                while (accountBalanceMap.get(getAccountNr) == null) {
                    System.out.println("Can't find that account number. Please enter correct account number.");
                    getAccountNr = scanner.nextLine();
                }
                System.out.println("Account nr:" + getAccountNr + " Balance: " + accountBalanceMap.get(getAccountNr));

            } else if (command.equalsIgnoreCase("depositMoney")) {
                System.out.println("Please enter account nr you want to add money:  ");
                String depositToAccountNr = scanner.nextLine();
                while (accountBalanceMap.get(depositToAccountNr) == null) {
                    System.out.println("Can't find that account number. Please enter correct account number.");
                    depositToAccountNr = scanner.nextLine();
                }
                System.out.println("Please enter amount of money you want to add:  ");
                BigDecimal addMoney = scanner.nextBigDecimal();
                scanner.nextLine();
                while (addMoney.compareTo(new BigDecimal(0)) < 0) {
                    System.out.println("Please enter amount bigger than 0.");
                    addMoney = scanner.nextBigDecimal();
                }
                BigDecimal currentBalance = accountBalanceMap.get(depositToAccountNr);
                BigDecimal newBalance = currentBalance.add(addMoney);
                accountBalanceMap.put(depositToAccountNr, newBalance);
                System.out.println("Added " + addMoney + "EUR. New balance:" + newBalance + " EUR");

            } else if (command.equalsIgnoreCase("withdrawMoney")) {
                System.out.println("Please enter account nr from you want to withdraw money:  ");
                String withDrawFromAccount = scanner.nextLine();
                while (accountBalanceMap.get(withDrawFromAccount) == null) {
                    System.out.println("Can't find that account number. Please enter correct account number.");
                    withDrawFromAccount = scanner.nextLine();
                }
                System.out.println("Please enter amount of money you want to withdraw: ");
                BigDecimal amountOfWithdraw = scanner.nextBigDecimal();
                BigDecimal currentBalance = accountBalanceMap.get(withDrawFromAccount);
                BigDecimal newBalance = currentBalance.subtract(amountOfWithdraw);
                while (amountOfWithdraw.compareTo(new BigDecimal(0)) <= 0 || newBalance.compareTo(new BigDecimal(0)) <= 0) {
                    System.out.println("Amount you entered, is not correct. Please enter new amount.");
                    amountOfWithdraw = scanner.nextBigDecimal();
                    newBalance = currentBalance.subtract(amountOfWithdraw);
                }
                accountBalanceMap.put(withDrawFromAccount, newBalance);
                System.out.println("Amount of withdraw: " + amountOfWithdraw + " EUR. " +
                        "New balance: " + newBalance + " EUR");


            } else if (command.equalsIgnoreCase("transfer")) {
                System.out.println("Please enter account nr FROM you want to transfer money:  ");
                String transferFromAccount = scanner.nextLine();
                while (accountBalanceMap.get(transferFromAccount) == null) {
                    System.out.println("Can't find that account number. Please enter correct account number.");
                    transferFromAccount = scanner.nextLine();

                }
                System.out.println("Please enter account nr ONTO you want to transfer money:  ");
                String transferToAccount = scanner.nextLine();
                while (accountBalanceMap.get(transferToAccount) == null) {
                    System.out.println("Can't find that account number. Please enter correct account number.");
                    transferToAccount = scanner.nextLine();

                }
                System.out.println("Please enter amount of money you want to transfer: ");
                BigDecimal amountOfTransfer = scanner.nextBigDecimal();
                BigDecimal currentBalance = accountBalanceMap.get(transferFromAccount);
                BigDecimal newBalance = currentBalance.subtract(amountOfTransfer);
                while (amountOfTransfer.compareTo(new BigDecimal(0)) <= 0 || newBalance.compareTo(new BigDecimal(0)) <= 0) {
                    System.out.println("Amount you entered, is not correct. Please enter new amount.");
                    amountOfTransfer = scanner.nextBigDecimal();
                    newBalance = currentBalance.subtract(amountOfTransfer);
                }
                accountBalanceMap.put(transferFromAccount, newBalance);
                BigDecimal toAccountBalance = accountBalanceMap.get(transferToAccount);
                BigDecimal newToAccountBalance = toAccountBalance.add(amountOfTransfer);
                accountBalanceMap.put(transferToAccount, newToAccountBalance);
                System.out.println("From account nr: " + transferFromAccount + " was transfered " + amountOfTransfer +
                        " EUR to account nr: " + transferToAccount);
                scanner.nextLine();


            } else if (command.equalsIgnoreCase("exit")) {
                break;
            }
            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific acount
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative
            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction
            else {
                System.out.println("Unknown command");
            }
        }
    }
}

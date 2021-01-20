package ee.bcs.valiit.tasks.controller;


import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

@RequestMapping("bank")
@RestController
public class Lesson4PankController {
    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    @GetMapping("createAccount/{accountNr}")
    public String createAcc(@PathVariable("accountNr") String accountNr) {
        accountMap.put(accountNr, new BigDecimal(0));
        return ("Account nr: " + accountNr + " created! / Balance: " + accountMap.get(accountNr));
        // http://localhost:8080/bank/createAccount?accountNr=EE123
    }

    @GetMapping("accountBalance/{accountNr}")
    public String getAccNr(@PathVariable("accountNr") String accountNr) {
        if (accountMap.get(accountNr) == null) {
            return "Can't find that account number. Please enter correct account number.";
        } else {
            return ("Account nr: " + accountNr + " / Balance: " + accountMap.get(accountNr));

        }
    }

    @GetMapping("depositMoney/{accountNr}/{sumOfMoney}")
    public String deposit(@PathVariable("accountNr") String accountNr, @PathVariable("sumOfMoney") String sumOfMoney) {
        BigDecimal Money = new BigDecimal(sumOfMoney);
        if (accountMap.get(accountNr) == null || Money.compareTo(new BigDecimal(0)) < 0) {
            return "Account number or amount of Money not correct!";
        } else {
            BigDecimal currentBalance = accountMap.get(accountNr);
            BigDecimal newBalance = currentBalance.add(Money);
            accountMap.put(accountNr, newBalance);
            return "Added " + Money + "EUR. / New balance on account number " + accountNr + " is: "
                    + newBalance + " EUR";
        }

    }

    @GetMapping("withdrawMoney/{accountNr}/{sumOfMoney}")
    public String withdraw(@PathVariable("accountNr") String accountNr, @PathVariable("sumOfMoney") String sumOfMoney) {
        BigDecimal Money = new BigDecimal(sumOfMoney);
        if (accountMap.get(accountNr) == null || Money.compareTo(new BigDecimal(0)) < 0) {
            return "Account number or amount of Money not correct!";
        } else {
            BigDecimal currentBalance = accountMap.get(accountNr);
            BigDecimal newBalance = currentBalance.subtract(Money);
            accountMap.put(accountNr, newBalance);
            return "Withdrawed " + Money + "EUR. / New balance on account number " + accountNr + " is: "
                    + newBalance + " EUR";
        }
    }

    @GetMapping("transfer/{fromAccount}/{toAccount}/{sumOfMoney}")
    public String transfer(@PathVariable("fromAccount") String fromAccount, @PathVariable("toAccount") String toAccount,
                           @PathVariable("sumOfMoney") String sumOfMoney) {
        BigDecimal Money = new BigDecimal(sumOfMoney);
        if (accountMap.get(fromAccount) == null || accountMap.get(toAccount) == null ||
                Money.compareTo(new BigDecimal(0)) < 0) {
            return "Account number or amount of Money not correct!";
        } else {
            BigDecimal currentBalance = accountMap.get(fromAccount);
            BigDecimal newBalance = currentBalance.subtract(Money);
            if (Money.compareTo(new BigDecimal(0)) <= 0 || newBalance.compareTo(new BigDecimal(0)) < 0) {
                return "Please enter correct sum you want to transfer";
            } else {
                accountMap.put(fromAccount, newBalance);
                BigDecimal toAccountBalance = accountMap.get(toAccount);
                BigDecimal newToAccountBalance = toAccountBalance.add(Money);
                accountMap.put(toAccount, newToAccountBalance);
                return "From account nr: " + fromAccount + " was transfered " + Money +
                        " EUR to account nr: " + toAccount;
            }
        }
    }
}










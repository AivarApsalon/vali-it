package ee.bcs.valiit.tasks.controller;


import ee.bcs.valiit.tasks.Employee;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("pank")
@RestController

public class BankController {
    HashMap<String, Integer> accountMap = new HashMap<>();


    @PostMapping("createAccount")
    public void konto(@RequestBody String konto) {
        accountMap.put(konto, 0);
    }


}

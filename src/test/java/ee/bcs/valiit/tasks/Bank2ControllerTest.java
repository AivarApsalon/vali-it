package ee.bcs.valiit.tasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.bcs.valiit.tasks.tasks.controller.Bank2;
import ee.bcs.valiit.tasks.tasks.controller.Bank2Customers;
import ee.bcs.valiit.tasks.tasks.controller.Bank2Transfer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class Bank2ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void newCustomer() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Bank2Customers bank2Customers = new Bank2Customers();
        bank2Customers.setName("Aare");
        bank2Customers.setFamilyName("Mets");
        bank2Customers.setIdCardNr("A0888");
        //http://localhost:8090/bank2/new-customer
        mockMvc.perform(MockMvcRequestBuilders.post("/bank2/new-customer")
                .contentType("application/json")
                .content(mapper.writeValueAsString(bank2Customers))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addAcc() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Bank2 bank2 = new Bank2();
        bank2.setAccountNr("EE008");
        bank2.setBalance(0);
        bank2.setCustomerId(4);
        System.out.println(mapper.writeValueAsString(bank2));
        //http://localhost:8090/bank2/create-acc
        mockMvc.perform(MockMvcRequestBuilders.post("/bank2/create-acc")
                .contentType("application/json")
                .content(mapper.writeValueAsString(bank2))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getBalance() throws Exception {
        //http://localhost:8090/bank2/get-balance/EE002
        mockMvc.perform(MockMvcRequestBuilders.get("/bank2/get-balance/EE002")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deposit() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Bank2 bank2 = new Bank2();
        bank2.setAccountNr("EE002");
        bank2.setAddAmount(200);
        //http://localhost90/bank2/deposit
        mockMvc.perform(MockMvcRequestBuilders.put("/bank2/deposit")
                .contentType("application/json")
                .content(mapper.writeValueAsString(bank2))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void withdraw() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Bank2 bank2 = new Bank2();
        bank2.setAccountNr("EE001");
        bank2.setWithdrawAmount(1);
        //http://localhost:8090/bank2/withdraw
        mockMvc.perform(MockMvcRequestBuilders.put("/bank2/withdraw")
                .contentType("application/json")
                .content(mapper.writeValueAsString(bank2))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void transfer() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Bank2Transfer bank2Transfer = new Bank2Transfer();
        bank2Transfer.setFromAccountNr("EE001");
        bank2Transfer.setToAccountNr("EE002");
        bank2Transfer.setTransferAmount(10);
        //http://localhost:8090/bank2/transfer
        mockMvc.perform(MockMvcRequestBuilders.put("/bank2/transfer")
                .contentType("application/json")
                .content(mapper.writeValueAsString(bank2Transfer))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }


}


















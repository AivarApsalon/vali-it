package ee.bcs.valiit.tasks.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControl {
    @GetMapping("test/{name}")
    public String getHelloWorld(@PathVariable ("name")String userName){
        return "Hello" + userName;
    }
}

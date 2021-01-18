package ee.bcs.valiit.tasks.controller;


import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2Controller {

    @GetMapping("Fibonacci/{n}")
    public int Fibonacci(@PathVariable("n") int nVariable) {
        return Lesson2.Fibonacci(nVariable);
    }




}

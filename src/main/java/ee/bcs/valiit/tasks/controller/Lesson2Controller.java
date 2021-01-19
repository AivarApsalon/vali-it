package ee.bcs.valiit.tasks.controller;


import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2Controller {

    @GetMapping("revArray")
    public int[] revArr(@RequestParam("array") int[] a) {
        return Lesson2.revArrayWeb(a);
        //localhost:8080/revArray?array=4,8,1,9,7,1
    }


    @GetMapping("printEvenNum")
    public int[] printEven(@RequestParam("x") int xVariable) {
        return Lesson2.printEvenNumWeb(xVariable);
        //localhost:8080/printEvenNum?x=4
    }


    @GetMapping("Fibonacci/{n}")
    public int Fibonacci(@PathVariable("n") int nVariable) {
        return Lesson2.Fibonacci(nVariable);
        //localhost:8080/Fibonacci/5
    }


    @GetMapping("threeN1/{n}/{m}")
    public String threeN1(@PathVariable("n") int nVariable, @PathVariable("m") int mVariable) {
        return Lesson2.threeN1Web(nVariable, mVariable);
    }



}

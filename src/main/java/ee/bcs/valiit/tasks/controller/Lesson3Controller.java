package ee.bcs.valiit.tasks.controller;


import ee.bcs.valiit.tasks.Lesson1MathUtil;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3Controller {

    @GetMapping("sumArray")
    public int sumArray(@RequestParam("array") int[] array){
        return Lesson3.sumArray(array);
    }

    @GetMapping("factorial/{n}")
    public int factorial(@PathVariable("n") int nVariable) {
        return Lesson3.factorial(nVariable);
    }

    @GetMapping("Sort")
    public int[] sort(@RequestParam("array") int[] array){
        return Lesson3.sort(array);
    }

    @GetMapping("revString")
    public String reverse(@RequestParam("string") String a ){
        return Lesson3.reverseString(a);
    }

    @GetMapping("isPrime/{a}")
    public boolean isPrime(@PathVariable("a") int aVariable) {
        return Lesson3.isPrime(aVariable);
    }


}

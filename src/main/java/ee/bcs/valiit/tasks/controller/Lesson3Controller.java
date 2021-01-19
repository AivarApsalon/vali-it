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
    public int sumArr(@RequestParam("array") int[] a){
        return Lesson3.sumArray(a);
        //localhost:8080/sumArray?array=1,2,3
    }


    @GetMapping("factorial/{n}")
    public int fact(@PathVariable("n") int nVariable) {
        return Lesson3.factorial(nVariable);
        //localhost:8080/factorial/(sisesta lihtsalt number n)
        //localhost:8080/factorial/5
    }



    @GetMapping("Sort")
    public int[] sortArray(@RequestParam("array") int[] a){
        return Lesson3.sort(a);
        //localhost:8080/Sort?array=1,6,4,3
    }



    @GetMapping("revString")
    public String reverse(@RequestParam("string") String a ){
        return Lesson3.reverseString(a);
        //localhost:8080/revString?string=Aivar
    }



    @GetMapping("isPrime/{a}")
    public boolean isPrime(@PathVariable("a") int aVariable) {
        return Lesson3.isPrime(aVariable);
        //localhost:8080/isPrime/(siia lihtsalt number)
        //localhost:8080/isPrime/9
    }


}

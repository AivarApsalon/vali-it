package ee.bcs.valiit.tasks.controller;


import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3HardController {

    @GetMapping("EvenFib/{n}")
    public int EvenFib(@PathVariable("n") int nVariable) {
        return Lesson3Hard.evenFibonacci(nVariable);
    }

    @GetMapping("morse")
    public String morse(@RequestParam("a") String a) {
        return Lesson3Hard.morseCode(a);
    }

    @GetMapping("morse2/{n}")
    public String morse2(@PathVariable("n") String n) {
        return Lesson3Hard.morseCode(n);


    }
}

package ee.bcs.valiit.tasks.tasks.controller;


import ee.bcs.valiit.tasks.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Lesson3HardController {

    @GetMapping("EvenFib/{n}")
    public int EvenFib(@PathVariable("n") int nVariable) {
        return Lesson3Hard.evenFibonacci(nVariable);
    }

    @GetMapping("morse")
    public String morse(@RequestParam("a") String a) {
        return Lesson3Hard.morseCode(a);
        //localhost:8080/morse?a=sos
    }

    @GetMapping("morse2/{n}")
    public String morse2(@PathVariable("n") String n) {
        return Lesson3Hard.morseCode(n);
        //localhost:8080/morse2/sos

    }


    int count = 0;
    Random random = new Random();
    int number = random.nextInt(100);

    @GetMapping("randomGameWeb")
    public String randomGameWeb(@RequestParam("arva") int arva) {

        count++;

        if (arva > number) {
            return ("Number on väiksem kui " + arva + ".");
        }
        else if (arva < number) {
            return ("Number on suurem kui " + arva + ".");
        } else{
            return ("ÕIGE! Sul kulus äraarvamiseks " + count + " korda.");
        }

    }


}




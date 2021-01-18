package ee.bcs.valiit.tasks.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3Controller {

    @GetMapping("sumArray")
    public int[] sumArray(@RequestParam("array") int[] array){
        return null;
    }





}

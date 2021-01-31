package ee.bcs.valiit.tasks.tasks.controller;

import ee.bcs.valiit.tasks.tasks.Lesson1MathUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Lesson1MathUtilController {

    @GetMapping("min2")
    public int min2(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable) {
        return Lesson1MathUtil.min(aVariable, bVariable);
    }

    @GetMapping("max2/{a}/{b}")
    public int max2(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable) {
        return Lesson1MathUtil.max(aVariable, bVariable);
    }

    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int aVariable) {
        return Lesson1MathUtil.abs(aVariable);
    }

    @GetMapping("isEven/{a}")
    public boolean isEven(@PathVariable("a") int aVariable) {
        return Lesson1MathUtil.isEven(aVariable);
    }

    @GetMapping("min3/{a}/{b}/{c}")
    public int min3(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable, @PathVariable("c") int cVariable) {
        return Lesson1MathUtil.min(aVariable, bVariable, cVariable);
    }

    @GetMapping("max3/{a}/{b}/{c}")
    public int max3(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable, @PathVariable("c") int cVariable) {
        return Lesson1MathUtil.max(aVariable, bVariable, cVariable);
    }

}

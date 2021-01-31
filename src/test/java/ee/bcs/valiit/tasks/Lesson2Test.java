package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.tasks.Lesson2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson2Test {

    @Test
    void revArrayWebTest() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, Lesson2.revArrayWeb(new int[]{6, 5, 4, 3, 2, 1}));

    }

    @Test
    void printEvenNumWebTest() {
        Assertions.assertArrayEquals(new int[]{2, 4, 6, 8, 10}, Lesson2.printEvenNumWeb(5));

    }

    @Test
    void fibonacciTest() {
        Assertions.assertEquals(8, Lesson2.Fibonacci(7));
        Assertions.assertEquals(0, Lesson2.Fibonacci(1));
        Assertions.assertEquals(1, Lesson2.Fibonacci(2));
        Assertions.assertEquals(1, Lesson2.Fibonacci(3));
    }

    @Test
    void threeN1Test() {
        Assertions.assertEquals(119, Lesson2.threeN1(1, 100));

    }
}

package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.tasks.Lesson2;
import ee.bcs.valiit.tasks.tasks.Lesson3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson3Test {

    @Test
    void sumArrayTest(){
        Assertions.assertEquals(10, Lesson3.sumArray(new int[] {1,2,3,4}));
        Assertions.assertEquals(15, Lesson3.sumArray(new int[] {1,2,3,4,5}));

    }

    @Test
    void factorialTest(){
        Assertions.assertEquals(120, Lesson3.factorial(5));
    }

    @Test
    void sortTest(){
        Assertions.assertArrayEquals(new int[]{6,5,4,3,2,1}, Lesson3.sort(new int[] {2,4,1,5,6,3}));
    }

    @Test
    void reverseStringTest(){
        Assertions.assertEquals("raviA", Lesson3.reverseString("Aivar"));
    }

    @Test
    void isPrimeTest(){
        Assertions.assertFalse(Lesson3.isPrime(9));
        Assertions.assertTrue(Lesson3.isPrime(7));
    }


}

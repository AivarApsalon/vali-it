package ee.bcs.valiit.tasks;


import ee.bcs.valiit.tasks.tasks.Lesson1MathUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson1MathUtilTest {

    @Test
    void testMin2() {
        Assertions.assertEquals(3, Lesson1MathUtil.min(3, 5));
        Assertions.assertEquals(2, Lesson1MathUtil.min(2, 5));
        Assertions.assertEquals(6, Lesson1MathUtil.min(7, 6));
        Assertions.assertEquals(-1, Lesson1MathUtil.min(1, -1));

    }

    @Test
    void testMax2() {
        Assertions.assertEquals(5, Lesson1MathUtil.max(5, 3));
        Assertions.assertEquals(5, Lesson1MathUtil.max(2, 5));
        Assertions.assertEquals(7, Lesson1MathUtil.max(-6, 7));
        Assertions.assertEquals(-6, Lesson1MathUtil.max(-6, -7));
    }

    @Test
    void testAbs() {
        Assertions.assertEquals(3, Lesson1MathUtil.abs(3));
        Assertions.assertEquals(2, Lesson1MathUtil.abs(-2));
        Assertions.assertEquals(0, Lesson1MathUtil.abs(0));

    }

    @Test
    void testIsEven() {
        Assertions.assertTrue(Lesson1MathUtil.isEven(8));
        Assertions.assertTrue(Lesson1MathUtil.isEven(-100));
        Assertions.assertFalse(Lesson1MathUtil.isEven(99));
        Assertions.assertFalse(Lesson1MathUtil.isEven(-1));

    }

    @Test
    void testMin3() {
        Assertions.assertEquals(3, Lesson1MathUtil.min(3, 5, 9));
        Assertions.assertEquals(5, Lesson1MathUtil.min(5, 5, 9));
        Assertions.assertEquals(4, Lesson1MathUtil.min(5, 10, 4));
        Assertions.assertEquals(1, Lesson1MathUtil.min(1, 4, 1));
        Assertions.assertEquals(-4, Lesson1MathUtil.min(1, -4, 1));
    }

    @Test
    void testMax3() {
        Assertions.assertEquals(5, Lesson1MathUtil.max(1, 1, 5));
        Assertions.assertEquals(4, Lesson1MathUtil.max(1, 4, 2));
        Assertions.assertEquals(20, Lesson1MathUtil.max(20, 5, 10));
        Assertions.assertEquals(5, Lesson1MathUtil.max(1, 1, 5));

    }

}

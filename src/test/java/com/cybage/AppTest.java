package com.cybage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    String input1 = "noon";
    App app = new App();
    boolean expected = true;

    @Test
    public void isPalindromeTest() {
        assertEquals(expected, app.isPalindrome(input1));
    }

    @Test
    public void isNotPalindromeTest() {
        assertEquals(false, app.isPalindrome("abc"));
    }

    @Test
    public void isPalindromeExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> app.isPalindrome(null));
    }

    // Test cases for calculator methods
    @Test
    public void addTest() {
        assertEquals(8, app.add(5, 3));
        assertEquals(-2, app.add(-5, 3));
        assertEquals(0, app.add(5, -5));
    }

    @Test
    public void subtractTest() {
        assertEquals(2, app.subtract(5, 3));
        assertEquals(-8, app.subtract(-5, 3));
        assertEquals(10, app.subtract(5, -5));
    }

    @Test
    public void multiplyTest() {
        assertEquals(15, app.multiply(5, 3));
        assertEquals(-15, app.multiply(-5, 3));
        assertEquals(-25, app.multiply(5, -5));
        assertEquals(0, app.multiply(5, 0));
    }

    @Test
    public void divideTest() {
        assertEquals(1.6666666666666667, app.divide(5, 3), 0.0001);
        assertEquals(-1.6666666666666667, app.divide(-5, 3), 0.0001);
        assertEquals(-1, app.divide(5, -5), 0.0001);
        assertEquals(0, app.divide(0, 5), 0.0001);
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> app.divide(5, 0));
    }
}

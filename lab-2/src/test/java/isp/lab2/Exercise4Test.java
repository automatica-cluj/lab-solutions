package isp.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise4Test {

    int[] someNumbers = new int[]{15, 18, 13, 22, 21, 11, 57, 141, 563, 16};

    @Test
    public void testIsPrimeNumber() {
        assertTrue("17 is a prime number", Exercise4.isPrimeNumber(17));
        assertFalse("20 isn't a prime number", Exercise4.isPrimeNumber(20));
    }

    @Test
    public void testFirstOdd() {
        assertEquals("The first odd number from the array should be 15", 15, Exercise4.firstOdd(someNumbers));
    }

    @Test
    public void testFirstEven() {
        assertEquals("The first even number from the array should be 18", 18, Exercise4.firstEven(someNumbers));
    }

    @Test
    public void testFirstPrime() {
        assertEquals("The first prime number from the array should be 13", 13, Exercise4.firstPrime(someNumbers));
    }
}

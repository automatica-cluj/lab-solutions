package isp.lab2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise3Test {
    int[] primeNumbers = new int[15];
    int[] myPN = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    @Before
    public void prepareTests() {
        for (int i = 0; i < myPN.length; i++) {
            primeNumbers[i] = myPN.length;
        }
    }

    @Test
    public void testIsPrimeNumber() {
        assertTrue("17 is a prime number", Exercise3.isPrimeNumber(17));
        assertFalse("20 isn't a prime number", Exercise3.isPrimeNumber(20));
    }

    @Test
    public void testCalculateSumOfDigits() {
        assertEquals("The sum of digits of number 17 should be 8", 8, Exercise3.calculateSumOfDigits(17));
        assertEquals("The sum of digits of number 20 should be 2", 2, Exercise3.calculateSumOfDigits(20));
    }

    @Test
    public void testPrimeNumbers() {
        int[] primeNumbers = Exercise3.getPrimeNumbersFromInterval(0, 50);
        assertEquals("There should be 15 prime numbers in the interval [0, 50]", 15, primeNumbers.length);
        for (int i = 0; i < myPN.length; i++) {
            assertEquals(primeNumbers[i], myPN[i]);
        }
    }

    @Test
    public void testCalculateGeometricMean() {
        assertEquals("The approximate geometric mean of the first 15 prime numbers should ve 15", 15, Math.round(Exercise3.calculateGeometricMean(myPN)));
    }

    @Test
    public void test3rdMethod() {
        assertEquals("There should be 7 numbers which have the sum of digits an even number in the first 15 prime numbers", 7, Exercise3.numberOfPNWithEvenSumOfDigits(myPN));
    }
}

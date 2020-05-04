package isp.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Exercise5Test {

    int[] someRandomNumbers = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 23, 45, 22, 123, -4};

    @Test
    public void testNumberGenerator() {
        int[] randomNumbers = Exercise5.generateRandomNumbers();
        assertEquals("There should be 20 numbers in that array", 20, randomNumbers.length);
        for (int number : randomNumbers) {
            assertTrue("No generated number should be outside this interval ->[-1000, 1000]", number > -1000 && number < 1000);
        }
    }

    @Test
    public void testGetSortedNumbers() {
        int[] sortedNumber = Exercise5.getSortedNumbers(someRandomNumbers);
        assertEquals("There should be 20 numbers in this array", 20, sortedNumber.length);
        for (int i = 0; i < sortedNumber.length - 1; i++) {
            assertTrue("The array should be sorted", sortedNumber[i] <= sortedNumber[i + 1]);
        }
    }
}

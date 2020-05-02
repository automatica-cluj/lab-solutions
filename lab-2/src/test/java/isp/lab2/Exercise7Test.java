package isp.lab2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Exercise7Test {

    @Test
    public void testGenerateARandom() {
        int aRandom = Exercise7.generateARandom();
        assertTrue("The random generated number should be grater then or equal to 0 and less then or equal to 7", aRandom >= 0 && aRandom <= 7);
    }
}

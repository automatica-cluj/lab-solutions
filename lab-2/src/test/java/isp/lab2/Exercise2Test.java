package isp.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise2Test {

    @Test
    public void testMessageToUser() {
        assertEquals("CFR Cluj", Exercise2.messageToUser(49));
        assertEquals("Universitatea Craiova", Exercise2.messageToUser(46));
        assertEquals("FCSB", Exercise2.messageToUser(43));
        assertEquals("FC Botosani", Exercise2.messageToUser(42));
        assertEquals("Gaz Metan", Exercise2.messageToUser(40));
        assertEquals("Astra Giurgiu", Exercise2.messageToUser(39));
        assertEquals("No team from Liga 1 have 5 points", Exercise2.messageToUser(5));
    }

}

package isp.lab3.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTest {

    @Test
    public void testGrow() {
        Tree tree = new Tree();
        assertEquals(15, tree.getHeight());
        tree.grow(-4);
        assertEquals(15, tree.getHeight());
        tree.grow(5);
        assertEquals(20, tree.getHeight());
    }

    @Test
    public void testToString() {
        Tree tree = new Tree();
        assertEquals("Tree{" + "height=" + 15 + '}',"Tree{" + "height=" + tree.getHeight() + '}');
    }
}

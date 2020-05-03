package isp.lab3.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTest {

    @Test
    public void testGrow() {
        Tree tree = new Tree();
        assertEquals("The height should be 15 as the constructor by default initialize the value to 15", 15, tree.getHeight());
        tree.grow(-4);
        assertEquals("The height should be 15 because the grow method should have no effect because of parameter less than 1", 15, tree.getHeight());
        tree.grow(5);
        assertEquals("The height should be 20 because we grow the tree by 5", 20, tree.getHeight());
    }

    @Test
    public void testSetHeight() {
        Tree tree = new Tree();
        tree.setHeight(-3);
        assertEquals("The height should be -3", -3, tree.getHeight());
    }

    @Test
    public void testToString() {
        Tree tree = new Tree();
        assertEquals("The toString method should have the correct format", "Tree{" + "height=" + 15 + '}', tree.toString());
    }
}

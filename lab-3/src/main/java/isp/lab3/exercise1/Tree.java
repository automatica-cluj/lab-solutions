package isp.lab3.exercise1;

public class Tree {
    private int height;

    /**
     * Constructor which initialize the height to 15
     */
    public Tree() {
        this.height = 15;
    }

    /**
     * Add the given meters to the current height
     * if the given value is greater than or equal with 1
     *
     * @param meters The given value to be added to the current height
     */
    public void grow(int meters) {
        if (meters >= 1) {
            this.height += meters;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Tree{" + "height=" + height + '}';
    }
}

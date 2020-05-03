package isp.lab3.exercise4;

public class MyPoint {
    private int x;
    private int y;
    private int z;

    /**
     * Default constructor which use default values from java
     */
    public MyPoint() {
    }

    /**
     * Constructor which set the x, y and z
     *
     * @param x to be set
     * @param y to be set
     * @param z to be set
     */
    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Methods which sets all given coordinates
     *
     * @param x given x coordinate to be set
     * @param y given y coordinate to be set
     * @param z given z coordinate to be set
     */
    public void setXYZ(int x, int y, int z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    /**
     * Calculate and return the distance between the current {@link MyPoint} and the given coordinates
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     * @param z the given z coordinate
     * @return the distance between the given coordinates and current {@link MyPoint}
     */
    public double distance(int x, int y, int z) {
        return Math.sqrt(Math.pow((double) x - (double) this.x, 2) + Math.pow((double) y - (double) this.y, 2) + Math.pow((double) z - (double) this.z, 2));
    }

    /**
     * Calculate and return the distance between the current {@link MyPoint} and another {@link MyPoint}
     *
     * @param another another{@link MyPoint} used to calculate distance from
     * @return the distance between current {@link MyPoint} and another {@link MyPoint}
     */
    public double distance(MyPoint another) {
        return distance(another.getX(), another.getY(), another.getZ());
    }

}

package isp.lab3.exercise4;

public class MyPoint {
    private int x;
    private int y;
    private int z;

    public MyPoint() {
    }

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

    public void setXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    public double distance(int x, int y, int z) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) + Math.pow(z - this.z, 2));
    }

    public double distance(MyPoint another) {
        return Math.sqrt(Math.pow(another.getX() - this.x, 2) + Math.pow(another.getY() - this.y, 2) + Math.pow(another.getZ() - this.z, 2));
    }

}

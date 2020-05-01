package isp.lab3.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        MyPoint point = new MyPoint(2, 3, 4);
        MyPoint another = new MyPoint(5, 6, 7);
        System.out.println(point.distance(another));
        System.out.println(point.distance(5, 6, 7));
        System.out.println(point);
        System.out.println(another);
    }
}

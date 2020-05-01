package isp.lab5.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        final Playable firstProxy = new ProxyVideo("Home", VideoType.COLOR);
        firstProxy.play();

        final Playable secondProxy = new ProxyVideo("It's a man's world.", VideoType.BLACK_AND_WHITE);
        secondProxy.play();
    }
}

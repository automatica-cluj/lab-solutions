package isp.lab5.exercise3;

public class BlackAndWhiteVideo implements Playable {
    private final String fileName;

    public BlackAndWhiteVideo(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void play() {
        System.out.println("Play black and white video " + this.fileName);
    }
}

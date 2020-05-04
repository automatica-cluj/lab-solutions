package isp.lab5.exercise3;

public class ColorVideo implements Playable {

    private final String fileName;

    public ColorVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void play() {
        System.out.println("Play " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading video..." + fileName);
    }
}

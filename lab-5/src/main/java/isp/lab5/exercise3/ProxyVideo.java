package isp.lab5.exercise3;

public class ProxyVideo implements Playable {

    private Playable video;
    private final VideoType videoType;
    private String fileName;

    public ProxyVideo(String fileName, VideoType videoType) {
        this.fileName = fileName;
        this.videoType = videoType;
    }

    @Override
    public void play() {
        if (video == null) {
            switch (videoType) {
                case COLOR:
                    video = new ColorVideo(fileName);
                    break;
                case BLACK_AND_WHITE:
                    video = new BlackAndWhiteVideo(fileName);
                    break;
                default:
                    System.out.println("No Playable implementation found for type: " + videoType);
                    return;
            }
        }
        video.play();
    }
}

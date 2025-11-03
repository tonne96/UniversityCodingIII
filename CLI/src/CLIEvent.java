import contract.MediaObject;

public class CLIEvent {
    private final MediaObject mediaObject;

    public CLIEvent(MediaObject mediaObject) {
        this.mediaObject = mediaObject;
    }

    public MediaObject getMediaObject() {
        return mediaObject;
    }
}

package domainLogic;

import contract.MediaObject;
import contract.Tag;
import contract.Uploader;
import contract.Video;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.List;

public class VideoImpl implements MediaObject, Video {

    @Override
    public long getMaxSize() {
        return 0;
    }

    @Override
    public void incrementAccessCount() {

    }

    @Override
    public void setAddress(String address) {

    }

    @Override
    public int getResolution() {
        return 0;
    }

    @Override
    public String getAddress() {
        return "";
    }

    @Override
    public Collection<Tag> getTags() {
        return List.of();
    }

    @Override
    public int getAccessCount() {
        return 0;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public Uploader getUploader() {
        return null;
    }

    @Override
    public Duration getAvailability() {
        return null;
    }

    @Override
    public BigDecimal getCost() {
        return null;
    }
}

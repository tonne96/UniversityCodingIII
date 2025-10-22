import contract.MediaContent;
import contract.Tag;
import contract.Uploader;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;

public class Audio implements MediaContent, contract.Audio {
    private int samplingRate;
    private String address;
    private Collection<Tag> tags;
    private int accessCount;
    private long size;
    private Uploader uploader;
    private Duration availability;
    private BigDecimal cost;



    public Audio() {
        accessCount++;
    }

    @Override
    public int getSamplingRate() {
        return samplingRate;
    }

    @Override
    public String getAddress() {
        accessCount++;
        return address;
    }

    @Override
    public Collection<Tag> getTags() {
        return tags;
    }

    @Override
    public int getAccessCount() {
        return accessCount;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public Uploader getUploader() {
        return uploader;
    }

    @Override
    public Duration getAvailability() {
        return availability;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }
}

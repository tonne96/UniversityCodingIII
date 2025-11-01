import contract.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;


public class AudioImpl implements MediaObject, contract.Audio {
    Instant create = Instant.now();
    private String title;
    private int samplingRate;
    private String address;
    private Collection<Tag> tags;
    private int accessCount;
    private long size;
    private Uploader uploader;
    private Duration availability;
    private BigDecimal cost;

    public AudioImpl() {
    }

    public AudioImpl(String title, int samplingRate, long size, BigDecimal cost, Collection<Tag> tags, Uploader uploader) {
        Instant create = Instant.now();
        int indexNumber = index;
        indexNumber++;
        this.address = "media://" + "Audio/" + uploader.getName() + "/" + indexNumber + "/" + create.toString();
        this.title = title;
        this.samplingRate = samplingRate;
        this.tags = tags;
        this.size = size;
        this.uploader = uploader;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int getSamplingRate() {
        return samplingRate;
    }

    @Override
    public String getAddress() {
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
        Instant now = Instant.now();
        return Duration.between(create, now);
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public void incrementAccessCounter() {
        accessCount++;
    }

    @Override
    public long getMaxSize() {
        return maxSize;
    }
}

package domainLogic;

import contract.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;


public class AudioImpl implements MediaObject, contract.Audio, UniqueAddressCreator {
    Instant create = Instant.now();
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

    public AudioImpl(Uploader uploader, Collection<Tag> tags, long size, BigDecimal cost, int samplingRate) {
        this.address = UniqueAddressCreator.createUniqueAddress() + "/type=Audio/uploader=" + uploader.getName() + "/tag=" + tags.toString() ;
        this.samplingRate = samplingRate;
        this.tags = tags;
        this.size = size;
        this.uploader = uploader;
        this.cost = cost;
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
    public long getMaxSize() {
        return maxSize;
    }

    @Override
    public void incrementAccessCount() {
        accessCount++;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

}

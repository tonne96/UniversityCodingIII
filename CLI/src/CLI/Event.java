package CLI;

import contract.Tag;
import contract.Uploader;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.EventObject;

public class Event extends EventObject {
    private Uploader uploader;
    private Collection<Tag> tags;
    private long size;
    private BigDecimal cost;
    private int samplingRate;
    private String address;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    public Event(Object source, Uploader uploader, Collection<Tag> tags, long size, BigDecimal cost, int samplingRate) {
        super(source);
        this.uploader = uploader;
        this.tags = tags;
        this.size = size;
        this.cost = cost;
        this.samplingRate = samplingRate;
    }

    public String getAddress() {
        return address;
    }

    public Uploader getUploader() {
        return uploader;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public long getSize() {
        return size;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public int getSamplingRate() {
        return samplingRate;
    }
}

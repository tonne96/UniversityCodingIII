package CLI.eventSystem.events;

import contract.Tag;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.EventObject;

public class AddMediaobjectEvent extends EventObject {
    String uploaderName;
    Collection<Tag> tags;
    long size;
    BigDecimal cost;
    int samplingRate;
    /**
     * Constructs a prototypical AddMediaobjectEvent.
     *
     * @param source the object on which the AddMediaobjectEvent initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public AddMediaobjectEvent(Object source, String uploaderName, Collection<Tag> tags, long size, BigDecimal cost, int samplingRate) {
        super(source);
        this.uploaderName = uploaderName;
        this.tags = tags;
        this.size = size;
        this.cost = cost;
        this.samplingRate = samplingRate;
    }

    public String getUploaderName() {
        return uploaderName;
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

import contract.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

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

    public AudioImpl(String title, Collection<Tag> tags, Uploader uploader) {
        int indexNumber = index;
        indexNumber++;
        this.address = "media://" + "Audio/" + uploader.getName() + "/" + indexNumber + "/" + create.toString();
        this.title = title;
        this.tags = tags;
        this.uploader = uploader;
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

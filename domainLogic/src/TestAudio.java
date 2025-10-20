import contract.Audio;
import contract.Tag;
import contract.Uploader;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.List;

public class TestAudio implements Audio {
    String address;

    public TestAudio(String address) {
        if (address == null) throw new NullPointerException("Address must not be null");
        this.address = address;
    }



    @Override
    public int getSamplingRate() {
        return 0;
    }

    @Override
    public String getAddress() {
        return address;
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

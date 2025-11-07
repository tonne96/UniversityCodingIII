package domainLogic;

import contract.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AudioImplTest {


    @Test
    void getSamplingRate() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertEquals(44100, audio.getSamplingRate());
    }

    @Test
    void getAddressIsUnique() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio1 = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        AudioImpl audio2 = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertNotEquals(audio1.getAddress(), audio2.getAddress());
    }

    @Test
    void getTags() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.emptyList(), 1024L, BigDecimal.valueOf(10), 44100);

        assertEquals(Collections.emptyList(), audio.getTags());
    }

    @Test
    void getAccessCount() {
        AudioImpl audio = new AudioImpl();
        int accessCount = audio.getAccessCount();

        assertEquals(accessCount, audio.getAccessCount());
    }

    @Test
    void getSize() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertEquals(1024L, audio.getSize());
    }

    @Test
    void getUploader() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertEquals(uploader, audio.getUploader());
    }

    @Test
    void getAvailability() {
        AudioImpl audio = new AudioImpl();

        Duration duration = audio.getAvailability();

        assertTrue(duration.toSeconds() >= 0);
    }

    @Test
    void getCost() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertEquals(BigDecimal.valueOf(10), audio.getCost());
    }

    @Test
    void incrementAccessCounter() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        int counter = audio.getAccessCount();

        audio.incrementAccessCount();

        assertEquals(counter + 1, audio.getAccessCount());
    }

    @Test
    void getMaxSize() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertTrue(audio.getMaxSize() > audio.getSize());
    }
}
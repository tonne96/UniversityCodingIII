import contract.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AudioImplTest {

    @Test
    void getTitle() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Animal), uploader);

        assertEquals("Test", audio.getTitle());
    }

    @Test
    void getSamplingRate() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Animal), uploader);

        assertEquals(44100, audio.getSamplingRate());
    }

    @Test
    void getAddress() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio1 = new AudioImpl("Test1", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Animal), uploader);
        AudioImpl audio2 = new AudioImpl("Test2", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Animal), uploader);

        assertNotEquals(audio1.getAddress(), audio2.getAddress());
    }

    @Test
    void getTags() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", 44100, 1024L, BigDecimal.valueOf(10),Collections.emptyList(), uploader);

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
        AudioImpl audio = new AudioImpl("Test", 44100, 1024L, BigDecimal.valueOf(10),Collections.emptyList(), uploader);

        assertEquals(1024L, audio.getSize());
    }

    @Test
    void getUploader() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Animal), uploader);

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
        AudioImpl audio = new AudioImpl("Test", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Animal), uploader);

        assertEquals(BigDecimal.valueOf(10), audio.getCost());
    }

    @Test
    void incrementAccessCounter() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Animal), uploader);
        int counter = audio.getAccessCount();

        audio.incrementAccessCounter();

        assertEquals(counter + 1, audio.getAccessCount());
    }

    @Test
    void getMaxSize() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Animal), uploader);

        assertTrue(audio.getMaxSize() > audio.getSize());
    }
}
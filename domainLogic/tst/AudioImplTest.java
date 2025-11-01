import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AudioImplTest {

    @Test
    void getTitle() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.emptyList(), uploader);

        assertEquals("Test", audio.getTitle());
    }

    @Test
    void getSamplingRate() {
        AudioImpl audio = mock(AudioImpl.class);
        when(audio.getSamplingRate()).thenReturn(41000);

        assertEquals(41000, audio.getSamplingRate());
    }

    @Test
    void getAddress() {
        fail();
    }

    @Test
    void getTags() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.emptyList(), uploader);

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
        AudioImpl audio = mock(AudioImpl.class);
        when(audio.getSize()).thenReturn(1024L);

        assertEquals(1024L, audio.getSize());
    }

    @Test
    void getUploader() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.emptyList(), uploader);

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
    }

    @Test
    void incrementAccessCounter() {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.emptyList(), uploader);
        int counter = audio.getAccessCount();

        audio.incrementAccessCounter();

        assertEquals(counter + 1, audio.getAccessCount());
    }

    @Test
    void getMaxSize() {
    }
}
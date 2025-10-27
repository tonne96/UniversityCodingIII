import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AudioImplTest {

    @Test
    void getSamplingRate() {
        fail();
    }

    @Test
    void getAddress() {
        fail();
    }

    @Test
    void getTags() {
        fail();
    }

    @Test
    void getAccessCount() {
        fail();
    }

    @Test
    void getSize() {
        fail();
    }

    @Test
    void getUploader() {
        fail();
    }

    @Test
    void getAvailability() {
        AudioImpl audioImpl = new AudioImpl();

        Duration duration = audioImpl.getAvailability();

        assertTrue(duration.toSeconds() >= 0);
    }

    @Test
    void getCost() {
        fail();
    }

    @Test
    void incrementAccessCounter() {
        fail();
    }
}
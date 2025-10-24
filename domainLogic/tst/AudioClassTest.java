import contract.Audio;
import contract.MediaObjects;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
class AudioClassTest {

    @Test
    void getAvailability() {
        AudioClass audioClass = new AudioClass();

        Duration duration = audioClass.getAvailability();

        assertTrue(duration.toSeconds() >= 0);
    }
}
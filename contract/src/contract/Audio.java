package contract;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface Audio extends MediaContent,Uploadable{
    int getSamplingRate();
}

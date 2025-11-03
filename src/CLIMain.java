import contract.Tag;

import java.math.BigDecimal;
import java.util.Collections;

public class CLIMain {
    public static void main(String[] args) {
        CLI cli = new CLI();
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("Uploader XYZ");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        cli.start(audio, administration);
    }
}

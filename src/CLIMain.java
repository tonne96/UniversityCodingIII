import contract.Tag;

import java.math.BigDecimal;
import java.util.Collections;

public class CLIMain {
    public static void main(String[] args) {
        CLI cli = new CLI();
        UploaderImpl uploader = new UploaderImpl("Uploader XYZ");
        AudioImpl audio = new AudioImpl("Rocksong", 44100, 1024L, BigDecimal.valueOf(10),Collections.singleton(Tag.Music), uploader);
        cli.start(audio);
    }
}

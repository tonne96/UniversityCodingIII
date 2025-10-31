import contract.Tag;

import java.util.Collections;

public class CLIMain {
    public static void main(String[] args) {
        Administration administration = new Administration();
        CLI cli = new CLI();
        UploaderImpl uploader = new UploaderImpl("Uploader XYZ");
        AudioImpl audio = new AudioImpl("Rocksong", Collections.singleton(Tag.Music), uploader);
        cli.start(audio);
    }
}

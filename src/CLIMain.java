import contract.MediaContent;
import contract.MediaObject;
import contract.Tag;
import domainLogic.Administration;
import domainLogic.AudioImpl;
import domainLogic.UploaderImpl;

import java.math.BigDecimal;
import java.util.Collections;

public class CLIMain {
    public static void main(String[] args) {
        /*
        CLI.CLI cli = new CLI.CLI();
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("Uploader XYZ");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        cli.start(audio, administration);

         */
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("Uploader XYZ");
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        administration.remove("media://ID=2");
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        for (MediaContent mediaContent : administration.listItems()) {
            System.out.println(mediaContent.getAddress());
        }

    }
}

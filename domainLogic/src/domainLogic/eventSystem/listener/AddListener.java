package domainLogic.eventSystem.listener;

import contract.Tag;
import domainLogic.Administration;
import domainLogic.UploaderImpl;
import domainLogic.eventSystem.events.AddEvent;

import java.math.BigDecimal;
import java.util.Collections;

public class AddListener implements EventListener<AddEvent> {
    Administration administration;

    public AddListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(AddEvent event) {
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        this.administration.addUploaderToList(uploader);
        this.administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
    }
}

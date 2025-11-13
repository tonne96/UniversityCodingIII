package CLI.eventSystem.listener;

import contract.Tag;
import domainLogic.Administration;
import domainLogic.UploaderImpl;
import CLI.eventSystem.events.AddMediaobjectEvent;

import java.math.BigDecimal;
import java.util.Collections;

public class AddMediaobjectListener implements EventListener<AddMediaobjectEvent> {
    Administration administration;

    public AddMediaobjectListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(AddMediaobjectEvent event) {
        this.administration.addMediaobjectToList(event.getUploaderName(), event.getTags(), event.getSize(), event.getCost(), event.getSamplingRate());
    }
}

package CLI.CLIListener;

import CLI.Event;
import CLI.EventListener;
import domainLogic.Administration;

public class AddListener implements EventListener {
    Administration administration;

    public AddListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(Event event) {
        this.administration.addMediaobjectToList(event.getUploader(), event.getTags(), event.getSize(), event.getCost(), event.getSamplingRate());
    }
}

package CLI.eventSystem.listener;

import CLI.eventSystem.events.AddUploaderEvent;
import domainLogic.Administration;
import domainLogic.UploaderImpl;

public class AddUploaderListener implements EventListener<AddUploaderEvent> {
    Administration administration;

    public AddUploaderListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(AddUploaderEvent event) {
        administration.addUploaderToList(new UploaderImpl(event.getName()));
    }
}

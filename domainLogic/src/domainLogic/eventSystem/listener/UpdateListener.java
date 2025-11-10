package domainLogic.eventSystem.listener;

import domainLogic.Administration;
import domainLogic.eventSystem.events.UpdateEvent;

public class UpdateListener implements EventListener<UpdateEvent> {
    Administration administration;

    public UpdateListener(Administration administration) {
        this.administration = administration;
    }

    public void onEvent(UpdateEvent updateEvent) {
        this.administration.update(updateEvent.getCommand());
    }

}

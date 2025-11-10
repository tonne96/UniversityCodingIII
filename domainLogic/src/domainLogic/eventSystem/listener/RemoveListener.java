package domainLogic.eventSystem.listener;

import domainLogic.Administration;
import domainLogic.eventSystem.events.RemoveEvent;

public class RemoveListener implements EventListener<RemoveEvent> {
    Administration administration;

    public RemoveListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(RemoveEvent removeEvent) {
        this.administration.remove(removeEvent.getCommand());

    }
}

package CLI.CLIListener;

import CLI.Event;
import CLI.EventListener;
import domainLogic.Administration;

public class UpdateListener implements EventListener {
    Administration administration;

    public UpdateListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(Event event) {
        this.administration.update(event.getAddress());
    }
}

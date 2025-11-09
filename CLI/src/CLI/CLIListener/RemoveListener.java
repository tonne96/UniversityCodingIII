package CLI.CLIListener;

import CLI.Event;
import CLI.EventListener;
import domainLogic.Administration;

public class RemoveListener implements EventListener {
    Administration administration;

    public RemoveListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(Event event) {
        this.administration.remove(event.getAddress());
    }
}

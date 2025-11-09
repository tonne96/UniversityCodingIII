package CLI.CLIListener;

import CLI.Event;
import CLI.EventListener;
import domainLogic.Administration;

public class ListListener implements EventListener {
    Administration administration;

    public ListListener(Administration administration) {
        this.administration = administration;
    }

// kennt Event SOurce CLI nicht
    // kennt Administration und führt CRUD aus

    @Override
    public void onEvent(Event event) {
        this.administration.listItems();
    }
}

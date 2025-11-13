package CLI.eventSystem.listener;

import CLI.eventSystem.events.PrintEvent;
import contract.MediaContent;
import domainLogic.Administration;

public class PrintListener implements EventListener<PrintEvent>{
    Administration administration;

    public PrintListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(PrintEvent event) {
        for (MediaContent m : event.getList()) {
            System.out.println(
                    "Adresse: " + m.getAddress() + " | " +
                            "Medientyp: " + m.getClass().getSimpleName() + " |"
                            + " Tag: " + m.getTags()
            );
        }
    }
}

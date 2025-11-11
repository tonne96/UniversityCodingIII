package CLI.eventSystem.listener;

import contract.MediaContent;
import domainLogic.Administration;
import CLI.eventSystem.events.ListEvent;

import java.util.List;

public class ListListener implements EventListener<ListEvent> {
    Administration administration;

    public ListListener(Administration administration) {
        this.administration = administration;
    }

    @Override
    public void onEvent(ListEvent listEvent) {
        List<MediaContent> mediaObjectList = this.administration.listItems();
        for (MediaContent m : mediaObjectList) {
            System.out.println(
                    "Adresse: " + m.getAddress() + " | " +
                    "Medientyp: " + m.getClass().getSimpleName() + " |"
                            + " Tag: " + m.getTags()
            );
        }
    }
}

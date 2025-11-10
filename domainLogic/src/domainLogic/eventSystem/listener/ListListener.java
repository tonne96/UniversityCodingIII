package domainLogic.eventSystem.listener;

import contract.MediaContent;
import domainLogic.Administration;
import domainLogic.eventSystem.events.ListEvent;

import java.util.List;

public class ListListener implements EventListener<ListEvent> {
    Administration administration;

    public ListListener(Administration administration) {
        this.administration = administration;
    }

// kennt AddEvent SOurce CLI nicht
    // kennt Administration und führt CRUD aus

    @Override
    public void onEvent(ListEvent listEvent) {
        List<MediaContent> mediaObjectList = this.administration.listItems();
        for (MediaContent m : mediaObjectList) {
            System.out.println(
                    "Medientyp: " + m.getClass().getSimpleName() + " |"
                            + " Tag: " + m.getTags()
            );
        }
    }
}

package CLI.eventSystem.listener;

import CLI.eventSystem.events.PrintEvent;
import CLI.eventSystem.handler.Handler;
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
        // Erstellt neuen Handler und leitet liste an neues Printevent weiter
        Handler<PrintListener, PrintEvent> printHandler = new Handler<>();
        printHandler.addListener(new PrintListener());
        printHandler.handle(new PrintEvent(this, this.administration.listItems()));
    }
}

package domainLogic.eventSystem.events;

import java.util.EventObject;

public class ListEvent extends EventObject {
    private final String command;


    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ListEvent(Object source, String command) {
        super(source);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

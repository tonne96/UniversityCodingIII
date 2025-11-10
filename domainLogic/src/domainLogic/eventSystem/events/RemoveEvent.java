package domainLogic.eventSystem.events;

import java.util.EventObject;

public class RemoveEvent extends EventObject {
    private final String command;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public RemoveEvent(Object source, String command) {
        super(source);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

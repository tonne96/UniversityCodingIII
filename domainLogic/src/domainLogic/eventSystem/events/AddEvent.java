package domainLogic.eventSystem.events;

import java.util.EventObject;

public class AddEvent extends EventObject {
    private final String command;

    /**
     * Constructs a prototypical AddEvent.
     *
     * @param source the object on which the AddEvent initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public AddEvent(Object source, String command) {
        super(source);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

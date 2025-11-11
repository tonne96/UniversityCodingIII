package CLI.eventSystem.events;

import java.util.EventObject;

public class ListEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ListEvent(Object source) {
        super(source);
    }
}

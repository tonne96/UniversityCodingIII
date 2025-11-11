package CLI.eventSystem.events;

import java.util.EventObject;

public class AddEvent extends EventObject {

    /**
     * Constructs a prototypical AddEvent.
     *
     * @param source the object on which the AddEvent initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public AddEvent(Object source) {
        super(source);
    }

}

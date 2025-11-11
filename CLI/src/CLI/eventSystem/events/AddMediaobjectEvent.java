package CLI.eventSystem.events;

import java.util.EventObject;

public class AddMediaobjectEvent extends EventObject {

    /**
     * Constructs a prototypical AddMediaobjectEvent.
     *
     * @param source the object on which the AddMediaobjectEvent initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public AddMediaobjectEvent(Object source) {
        super(source);
    }

}

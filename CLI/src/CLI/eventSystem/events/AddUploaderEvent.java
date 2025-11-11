package CLI.eventSystem.events;

import java.util.EventObject;

public class AddUploaderEvent extends EventObject {
    private final String name;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public AddUploaderEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

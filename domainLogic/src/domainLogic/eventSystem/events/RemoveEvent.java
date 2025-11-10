package domainLogic.eventSystem.events;

import java.util.EventObject;

public class RemoveEvent extends EventObject {
    private final String address;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public RemoveEvent(Object source, String address) {
        super(source);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

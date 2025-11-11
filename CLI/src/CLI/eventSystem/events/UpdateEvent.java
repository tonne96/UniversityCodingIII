package CLI.eventSystem.events;

import java.util.EventObject;

public class UpdateEvent extends EventObject {
    private final String address;

    public UpdateEvent(Object source, String address) {
        super(source);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

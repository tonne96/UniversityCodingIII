package domainLogic.eventSystem.events;

import java.util.EventObject;

public class UpdateEvent extends EventObject {
    private final String command;

    public UpdateEvent(Object source, String command) {
        super(source);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

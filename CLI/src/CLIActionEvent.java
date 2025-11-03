import contract.MediaObject;

public class CLIActionEvent extends CLIEvent {
    private final String command;

    public CLIActionEvent(MediaObject mediaObject, String command) {
        super(mediaObject);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

package CLI;

import java.util.ArrayList;
import java.util.List;

public class CLIEventHandler {
    private final List<CLIActionListener> listeners = new ArrayList<>();

    public void addCLIListener(CLIActionListener actionListener) {
        listeners.add(actionListener);
    }

    public void removeCLIListener(CLIActionListener actionListener) {
        listeners.remove(actionListener);
    }

    public void fireEvent(CLIActionEvent actionEvent) {
        for (CLIActionListener cliActionListener: listeners) {
            cliActionListener.actionPerformed(actionEvent);
        }
    }
}

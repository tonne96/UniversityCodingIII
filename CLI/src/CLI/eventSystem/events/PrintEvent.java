package CLI.eventSystem.events;

import contract.MediaContent;

import java.util.EventObject;
import java.util.List;

public class PrintEvent extends EventObject {
    private final List<MediaContent> list;

    public PrintEvent(Object source, List<MediaContent> list) {
        super(source);
        this.list = list;
    }

    public List<MediaContent> getList() {
        return list;
    }
}

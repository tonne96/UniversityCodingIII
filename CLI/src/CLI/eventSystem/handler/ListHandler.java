package CLI.eventSystem.handler;

import CLI.eventSystem.events.ListEvent;
import CLI.eventSystem.listener.ListListener;

import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;

public class ListHandler {

    private List<ListListener> listenerList = new LinkedList<>();

    public void addListener(ListListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(EventListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(ListEvent listEvent) {
        for (ListListener listener : listenerList) {
            listener.onEvent(listEvent);
        }
    }
}

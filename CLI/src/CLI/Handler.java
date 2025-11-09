package CLI;

import java.util.LinkedList;
import java.util.List;

public class Handler {
    // verschiedene Handler CRUD typen
    // beliebig viele Listener können sich registrieren
    // gibt Event an alle registrierten Listener weiter
    private List<EventListener> listenerList = new LinkedList<>();

    public void addListener(EventListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(EventListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(Event event) {
        for (EventListener listener : listenerList) {
            listener.onEvent(event);
        }
    }
}

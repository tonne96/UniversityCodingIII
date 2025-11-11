package CLI.eventSystem.handler;

import CLI.eventSystem.listener.EventListener;

import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;

public class Handler <T extends EventListener<E>, E extends EventObject>{
    private final List<T> listenerList = new LinkedList<>();

    public void addListener(T listener) {
        this.listenerList.add(listener);
    }

    public void remove(T listener) {
        this.listenerList.remove(listener);
    }

    public void handle(E event) {
        for (T listener : listenerList) {
            listener.onEvent(event);
        }
    }
}

package CLI;

public interface EventListener extends java.util.EventListener {
    void onEvent(Event event);
}

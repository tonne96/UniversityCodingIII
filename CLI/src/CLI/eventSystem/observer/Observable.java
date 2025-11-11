package CLI.eventSystem.observer;

public interface Observable {
    void attachObserver(Observer o);
    void detachObserver(Observer o);
    void notifyObservers(String status);
}

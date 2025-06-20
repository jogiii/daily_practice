package observer;

public interface Subject {
    void attach(Observer o);
    void remove(Observer o);
    void notifyObservers();

}

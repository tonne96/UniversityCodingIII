package contract;

public interface MediaObjects extends MediaContent, Uploadable{
    void incrementAccessCounter();
}

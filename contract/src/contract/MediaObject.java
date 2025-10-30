package contract;

public interface MediaObject extends MediaContent, Uploadable{
    void incrementAccessCounter();
    int index = 1;
    long maxSize = (long) 1024 * 1024 * 1024; // 1GB
    long getMaxSize();
}

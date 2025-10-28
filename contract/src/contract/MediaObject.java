package contract;

public interface MediaObject extends MediaContent, Uploadable{
    void incrementAccessCounter();
    long maxSize = (long) 1024 * 1024 * 1024; // 1GB
    long getMaxSize();
}

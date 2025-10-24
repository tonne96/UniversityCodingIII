package contract;

public interface MediaObjects extends MediaContent, Uploadable{
    void incrementAccessCounter();
    long maxSize = (long) 1024 * 1024 * 1024; // 1GB
}

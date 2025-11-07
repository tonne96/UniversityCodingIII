package contract;

public interface MediaObject extends MediaContent, Uploadable{

    long maxSize = (long) 1024 * 1024 * 1024; // 1GB
    long getMaxSize();
    void incrementAccessCount();
    void setAddress(String address);
}

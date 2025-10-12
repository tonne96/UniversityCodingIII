package contract;

import java.util.Collection;

public interface MediaContent {
    String getAddress();
    Collection<Tag> getTags();
    int getAccessCount();
    long getSize();
}
